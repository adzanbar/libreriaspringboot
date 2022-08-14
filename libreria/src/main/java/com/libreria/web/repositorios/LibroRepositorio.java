package com.libreria.web.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.libreria.web.entidades.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String>{

	Optional<Libro> findById(String id);
	
	@Query("SELECT l FROM Libro l WHERE l.alta = true")
	List<Libro> leer();
	
}
