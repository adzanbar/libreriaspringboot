package com.libreria.web.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.web.entidades.Editorial;
import com.libreria.web.errores.ErrorServicio;
import com.libreria.web.repositorios.EditorialRepositorio;

@Service
public class EditorialServicio {
	
	@Autowired
	private EditorialRepositorio editorialRepositorio;
	
	@Transactional
	public void crear(String nombre) throws ErrorServicio{
		if (nombre == null || nombre.isBlank()) {
			throw new ErrorServicio("Nombre inválido");
		}
		editorialRepositorio.save(new Editorial(nombre));
	}
	
	public List<Editorial> leer() {
		return editorialRepositorio.leer();
	}
	
	@Transactional
	public void actualizar(String id, String nombre) throws ErrorServicio {
		Editorial editorial = editorialRepositorio.findById(id).get();
		editorial.setNombre(nombre);
		editorialRepositorio.save(editorial);
	}
	
	@Transactional
	public void eliminar(String id) throws ErrorServicio {
		Editorial editorial = editorialRepositorio.findById(id).get();
		editorial.setAlta(false);
		editorialRepositorio.save(editorial);
	}
}
