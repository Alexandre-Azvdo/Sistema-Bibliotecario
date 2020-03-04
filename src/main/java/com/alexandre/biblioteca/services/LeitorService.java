package com.alexandre.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexandre.biblioteca.domain.Cidade;
import com.alexandre.biblioteca.domain.Endereco;
import com.alexandre.biblioteca.domain.Leitor;
import com.alexandre.biblioteca.domain.dto.LeitorDTO;
import com.alexandre.biblioteca.domain.dto.LeitorNewDTO;
import com.alexandre.biblioteca.domain.enums.StatusLeitor;
import com.alexandre.biblioteca.repositories.EnderecoRepository;
import com.alexandre.biblioteca.repositories.LeitorRepository;
import com.alexandre.biblioteca.services.exceptions.DataIntegrityException;
import com.alexandre.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class LeitorService {

	@Autowired
	private LeitorRepository repo;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Leitor findById(Integer id) {
		Optional<Leitor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Leitor.class.getName()));
	}
	
	@Transactional
	public Leitor insert(Leitor obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Leitor update(Leitor obj) {
		Leitor newObj = findById(obj.getId());	
		updateData(newObj, obj);		
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Leitor que está associados a um XXX!");
		}
	}
	
	public List<Leitor> findAll(){
		return repo.findAll();
	}
	
	public Page<Leitor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Leitor fromDTO(LeitorDTO objDto) {
		Leitor leitor = new Leitor(objDto.getId(), objDto.getNome(), objDto.getDataNascimento(), null, StatusLeitor.toEnum(objDto.getStatus()), objDto.getEmail());
		leitor.setTelefones(objDto.getTelefones());
		
		for (Endereco x : objDto.getEnderecos()) {
			Cidade c = new Cidade(x.getCidade().getId(), null, null);
			Endereco e = new Endereco(x.getId(), x.getLogradouro(), x.getNumero(),  x.getBairro(), x.getComplemento(), x.getCep(), c);
			leitor.getEnderecos().add(e);
		}
		
		return leitor;
	}
	
	public Leitor fromDTO(LeitorNewDTO objDto) {	
		Leitor leitor =  new Leitor(null, objDto.getNome(), objDto.getDataNascimento(), objDto.getCpf(), StatusLeitor.toEnum(objDto.getStatus()), objDto.getEmail());
		leitor.setTelefones(objDto.getTelefones());
				
		for (Endereco x : objDto.getEnderecos()) {
			Cidade c = new Cidade(x.getCidade().getId(), null, null);
			Endereco e = new Endereco(x.getId(), x.getLogradouro(), x.getNumero(),  x.getBairro(), x.getComplemento(), x.getCep(), c);
			leitor.getEnderecos().add(e);
		}
		return leitor;
	}
	
	private void updateData(Leitor newObj, Leitor obj) {
		newObj.setNome(obj.getNome());		
		newObj.setDataNascimento(obj.getDataNascimento());
		newObj.setStatus(obj.getStatus());
		newObj.setEmail(obj.getEmail());
		newObj.setTelefones((obj.getTelefones()));
		newObj.setEnderecos(obj.getEnderecos());

	}

}
