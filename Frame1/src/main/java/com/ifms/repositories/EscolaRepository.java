package com.ifms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.entities.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {

}
