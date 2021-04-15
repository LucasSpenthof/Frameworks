package com.ifms.dto;

import java.io.Serializable;

import com.ifms.entities.Escola;

public class EscolaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String endereco;
	private String site;
	private String email;
	private String diretor;
	private String telefone;
	
	public EscolaDTO() {
	}

	
	
	public EscolaDTO(Long id, String nome, String endereco, String site, String email, String diretor,
			String telefone) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.site = site;
		this.email = email;
		this.diretor = diretor;
		this.telefone = telefone;
	}



	public EscolaDTO(Escola entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.endereco = entity.getEndereco();
		this.site = entity.getSite();
		this.email = entity.getEmail();
		this.diretor = entity.getDiretor();
		this.telefone = entity.getTelefone();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getSite() {
		return site;
	}



	public void setSite(String site) {
		this.site = site;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDiretor() {
		return diretor;
	}



	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	

}
