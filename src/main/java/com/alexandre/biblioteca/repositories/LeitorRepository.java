package com.alexandre.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexandre.biblioteca.domain.Leitor;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Integer>{

}
