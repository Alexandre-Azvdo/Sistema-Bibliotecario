package com.alexandre.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexandre.biblioteca.domain.Exemplar;;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Integer>{

}
