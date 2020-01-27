package com.alexandre.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexandre.biblioteca.domain.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{

}
