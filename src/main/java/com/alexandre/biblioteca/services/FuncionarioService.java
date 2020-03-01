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
import com.alexandre.biblioteca.domain.Funcionario;
import com.alexandre.biblioteca.domain.dto.FuncionarioDTO;
import com.alexandre.biblioteca.domain.dto.FuncionarioNewDTO;
import com.alexandre.biblioteca.repositories.EnderecoRepository;
import com.alexandre.biblioteca.repositories.FuncionarioRepository;
import com.alexandre.biblioteca.services.exceptions.DataIntegrityException;
import com.alexandre.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Funcionario findById(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}
		
	@Transactional
	public Funcionario insert(Funcionario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.save(obj.getEndereco());
		return obj;
	}
	
	public Funcionario update(Funcionario obj) {
		Funcionario newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Funcionario que está associados a um XXX!");
		}
	}
	
	public List<Funcionario> findAll(){
		return repo.findAll();
	}
	
	public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}	
	
	public Funcionario fromDTO(FuncionarioDTO objDto) {			
		Funcionario funcionario = new Funcionario(objDto.getId(), objDto.getMatricula(),objDto.getNome(), null, objDto.getEmail());
		
		Cidade cidade  = new Cidade(objDto.getCidadeId(),null, null);
		Endereco endereco = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getBairro(), objDto.getComplemento(), objDto.getCep(), cidade);
		funcionario.setEndereco(endereco);

		return funcionario;
	}
	
	public Funcionario fromDTO(FuncionarioNewDTO objDto) {			
		Funcionario funcionario = new Funcionario(null, objDto.getMatricula(),objDto.getNome(), objDto.getCpf(), objDto.getEmail());
		funcionario.getTelefones().addAll(objDto.getTelefones());
		Cidade cidade  = new Cidade(objDto.getCidadeId(),null, null);
		Endereco endereco = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getBairro(), objDto.getComplemento(), objDto.getCep(), cidade);
		funcionario.setEndereco(endereco);
		
		return funcionario;
	}
	
	private void updateData(Funcionario newObj, Funcionario obj) {
		newObj.setMatricula(obj.getMatricula());
		newObj.setNome(obj.getNome());			
		newObj.setEmail(obj.getEmail());
		newObj.setEndereco(obj.getEndereco());
	}
}
