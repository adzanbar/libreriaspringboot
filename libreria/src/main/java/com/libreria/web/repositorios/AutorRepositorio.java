package com.libreria.web.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.libreria.web.entidades.Autor;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String>{
	
	Optional<Autor> findById(String id);
	
	@Query("SELECT a FROM Autor a WHERE a.alta = true")
	List<Autor> leer();
}
