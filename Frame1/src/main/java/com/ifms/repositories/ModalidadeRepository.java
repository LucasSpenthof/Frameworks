package com.ifms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.entities.Modalidade;

@Repository
public interface ModalidadeRepository extends JpaRepository<Modalidade, Long> {

}
