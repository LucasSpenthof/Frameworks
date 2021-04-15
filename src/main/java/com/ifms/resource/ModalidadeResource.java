package com.ifms.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ifms.dto.ModalidadeDTO;
import com.ifms.services.ModalidadeService;

@RestController
@RequestMapping(value = "/modalidades")
public class ModalidadeResource {
	
	@Autowired
	private ModalidadeService service;
	
	@GetMapping
	public ResponseEntity<List<ModalidadeDTO>> findAll(){
		List<ModalidadeDTO> lista = service.findAll();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModalidadeDTO> findById(@PathVariable Long id){
		ModalidadeDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
		
	}
	
	@PostMapping
	public ResponseEntity<ModalidadeDTO> insert(@RequestBody ModalidadeDTO dto){
		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ModalidadeDTO> update(@PathVariable Long id, @RequestBody ModalidadeDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ModalidadeDTO> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
