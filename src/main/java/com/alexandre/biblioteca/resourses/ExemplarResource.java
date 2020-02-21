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

import com.alexandre.biblioteca.domain.Exemplar;
import com.alexandre.biblioteca.domain.dto.ExemplarDTO;
import com.alexandre.biblioteca.services.ExemplarService;

@RestController
@RequestMapping(value = "/exemplares")
public class ExemplarResource {

	@Autowired
	private ExemplarService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Exemplar> find(@PathVariable Integer id) {
		Exemplar obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ExemplarDTO objDto){
		Exemplar obj = service.fromDto(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ExemplarDTO objDto, @PathVariable Integer id){
		Exemplar obj = service.fromDto(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Exemplar> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ExemplarDTO>> findAll() {	
		List<Exemplar> list = service.findAll();	
		List<ExemplarDTO> listDto = list.stream().map(obj -> new ExemplarDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ExemplarDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "identificador")String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {	
		Page<Exemplar> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ExemplarDTO> listDto = list.map(obj -> new ExemplarDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
