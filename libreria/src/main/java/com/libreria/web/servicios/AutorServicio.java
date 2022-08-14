package com.libreria.web.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.web.entidades.Autor;
import com.libreria.web.errores.ErrorServicio;
import com.libreria.web.repositorios.AutorRepositorio;

@Service
public class AutorServicio {
	
	@Autowired
	private AutorRepositorio autorRepositorio;
	
	@Transactional
	public void crear(String nombre) throws ErrorServicio{
		if (nombre == null || nombre.isBlank()) {
			throw new ErrorServicio("Nombre inválido");
		}
		autorRepositorio.save(new Autor(nombre));
	}
	
	public List<Autor> leer() {
		return autorRepositorio.leer();
	}
	
	@Transactional
	public void actualizar(String id, String nombre) throws ErrorServicio {
		Autor autor = autorRepositorio.findById(id).get();
		autor.setNombre(nombre);
		autorRepositorio.save(autor);
	}
	
	@Transactional
	public void eliminar(String id) throws ErrorServicio {
		Autor autor = autorRepositorio.findById(id).get();
		autor.setAlta(false);
		autorRepositorio.save(autor);
	}
}
