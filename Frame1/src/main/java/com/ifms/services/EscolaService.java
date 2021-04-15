package com.ifms.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.EscolaDTO;
import com.ifms.entities.Escola;
import com.ifms.repositories.EscolaRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class EscolaService {
	
	@Autowired
	private EscolaRepository repository;

	
	@Transactional(readOnly = true)
	public List<EscolaDTO> findAll() {
		List<Escola> list = repository.findAll();
		return list.stream().map(escola -> new EscolaDTO(escola)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public EscolaDTO findById(Long id) {
		Optional<Escola> obj = repository.findById(id);
		Escola escola  = obj.orElseThrow(() -> new ResourceNotFoundException("A escola solicitada não foi encontrada"));
		return new EscolaDTO(escola);
	}

	@Transactional
	public EscolaDTO insert(EscolaDTO dto) {
		Escola entity = new Escola();
		entity.setNome(dto.getNome());
		entity.setEndereco(dto.getEndereco());
		entity.setSite(dto.getSite());
		entity.setEmail(dto.getEmail());
		entity.setDiretor(dto.getDiretor());
		entity.setTelefone(dto.getTelefone());
		entity = repository.save(entity);
		return new EscolaDTO(entity);
	}

	@Transactional
	public EscolaDTO update(Long id, EscolaDTO dto) {
		try {
			Escola entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			entity.setEndereco(dto.getEndereco());
			entity.setSite(dto.getSite());
			entity.setEmail(dto.getEmail());
			entity.setDiretor(dto.getDiretor());
			entity.setTelefone(dto.getTelefone());
			entity = repository.save(entity);
			return new EscolaDTO(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id nao foi localizado");
		}
	}

	public void delete(Long id) {
		repository.deleteById(id);
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O id nao foi localizado");
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException("violação de integridade");
		}
		
	}
}
