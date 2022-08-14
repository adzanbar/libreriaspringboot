package com.libreria.web.servicios;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.web.entidades.Autor;
import com.libreria.web.entidades.Editorial;
import com.libreria.web.entidades.Libro;
import com.libreria.web.errores.ErrorServicio;
import com.libreria.web.repositorios.LibroRepositorio;

@Service
public class LibroServicio {

	@Autowired
	private LibroRepositorio libroRepositorio;
	
	@Transactional
	public void crear(Long isbn, String titulo, Integer anio, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Autor autor, Editorial editorial) throws ErrorServicio {
		if (isbn == null || titulo == null || titulo.isBlank()) {
			throw new ErrorServicio("Datos inválido");
		}
		libroRepositorio.save(new Libro(isbn, titulo, anio, ejemplaresPrestados, ejemplaresRestantes, autor, editorial));
	}
	
	public List<Libro> leer() {
		return libroRepositorio.leer();
	}
	
	@Transactional
	public void actualizar(String id, Long isbn, String titulo, Integer anio, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Autor autor, Editorial editorial) throws ErrorServicio {
		if (isbn == null || titulo == null || titulo.isBlank()) {
			throw new ErrorServicio("Datos inválido");
		}
		Libro libro = libroRepositorio.findById(id).get();
		libro.setIsbn(isbn);
		libro.setTitulo(titulo);
		libro.setAnio(anio);
		libro.setEjemplares(ejemplaresPrestados + ejemplaresRestantes);
		libro.setEjemplaresPrestados(ejemplaresPrestados);
		libro.setEjemplaresRestantes(ejemplaresRestantes);
		libro.setAutor(autor);
		libro.setEditorial(editorial);
		libroRepositorio.save(libro);
	}
	
	@Transactional
	public void eliminar(String id) {
		Libro libro = libroRepositorio.findById(id).get();
		libro.setAlta(false);
		libroRepositorio.save(libro);
	}
}
