package com.libreria.web.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.libreria.web.entidades.Editorial;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String>{
	
	Optional<Editorial> findById(String id);
	
	@Query("SELECT e FROM Editorial e WHERE e.alta = true")
	List<Editorial> leer();
}
