package com.ifms.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_atleta")
public class Atleta extends Pessoa<Long>{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
