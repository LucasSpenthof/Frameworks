package com.ifms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Equipe implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeTime;
	
	@ManyToOne
	@JoinColumn(name = "id_tecnico_fk")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "id_escola_fk")
	private Escola escola;
	
	@ManyToOne
	@JoinColumn(name = "id_modalidade_fk")
	private Modalidade modalidade;

}
