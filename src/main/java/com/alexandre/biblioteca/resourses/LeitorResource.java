package com.alexandre.biblioteca.resourses;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alexandre.biblioteca.domain.Leitor;
import com.alexandre.biblioteca.domain.dto.LeitorDTO;
import com.alexandre.biblioteca.domain.dto.LeitorNewDTO;
import com.alexandre.biblioteca.services.LeitorService;

@RestController
@RequestMapping(value = "/leitores")
public class LeitorResource {

	@Autowired
	private LeitorService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Leitor> find(@PathVariable Integer id) {
		Leitor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody LeitorNewDTO objDto){
		Leitor obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody LeitorDTO objDto, @PathVariable Integer id){
		Leitor obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Leitor> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<LeitorDTO>> findAll() {	
		List<Leitor> list = service.findAll();	
		List<LeitorDTO> listDto = list.stream().map(obj -> new LeitorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<LeitorDTO>> findPage(
			@RequestParam(name = "page", defaultValue = "0") Integer page, 
			@RequestParam(name = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(name = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(name = "direction", defaultValue = "ASC") String direction) {	
		Page<Leitor> list = service.findPage(page, linesPerPage, orderBy, direction);	
		Page<LeitorDTO> listDto = list.map(obj -> new LeitorDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
