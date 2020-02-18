package com.alexandre.biblioteca.resourses;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.alexandre.biblioteca.domain.Emprestimo;
import com.alexandre.biblioteca.domain.dto.EmprestimoDTO;
import com.alexandre.biblioteca.services.EmprestimoService;

@RestController
@RequestMapping(value = "/emprestimos")
public class EmprestimoResource {

	@Autowired
	private EmprestimoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Emprestimo> find(@PathVariable Integer id) {
		Emprestimo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Emprestimo obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Emprestimo obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Emprestimo> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EmprestimoDTO>> findAll() {	
		List<Emprestimo> list = service.findAll();	
		List<EmprestimoDTO> listDto = list.stream().map(obj -> new EmprestimoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<EmprestimoDTO>> findPage(
			@RequestParam(name = "page", defaultValue = "0") Integer page, 
			@RequestParam(name = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(name = "orderBy", defaultValue = "status") String orderBy, 
			@RequestParam(name = "direction", defaultValue = "ASC") String direction) {	
		Page<Emprestimo> list = service.findPage(page, linesPerPage, orderBy, direction);	
		Page<EmprestimoDTO> listDto = list.map(obj -> new EmprestimoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
