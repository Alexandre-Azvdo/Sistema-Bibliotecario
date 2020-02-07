package com.alexandre.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexandre.biblioteca.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{

}
