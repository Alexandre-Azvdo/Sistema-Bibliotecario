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
import com.alexandre.biblioteca.domain.Contato;
import com.alexandre.biblioteca.domain.Endereco;
import com.alexandre.biblioteca.domain.Leitor;
import com.alexandre.biblioteca.domain.dto.LeitorDTO;
import com.alexandre.biblioteca.domain.dto.LeitorNewDTO;
import com.alexandre.biblioteca.domain.enums.StatusLeitor;
import com.alexandre.biblioteca.repositories.ContatoRepository;
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
	@Autowired
	private ContatoRepository contatoRepository;

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
		contatoRepository.save(obj.getContato());
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
		Contato contato = new Contato(null, objDto.getEmails(), objDto.getTelefones());
		return new Leitor(objDto.getId(), objDto.getNome(), objDto.getDataNascimento(), null, StatusLeitor.toEnum(objDto.getStatus()), contato);
	}
	
	public Leitor fromDTO(LeitorNewDTO objDto) {
		Contato contato = new Contato(null, objDto.getEmails(), objDto.getTelefones());		
		Leitor leitor =  new Leitor(null, objDto.getNome(), objDto.getDataNascimento(), objDto.getCpf(), StatusLeitor.toEnum(objDto.getStatus()), contato);
		
		Cidade cidade  = new Cidade(objDto.getCidadeId(),null, null);
		Endereco endereco = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getBairro(), objDto.getComplemento(), objDto.getCep(), cidade);
		
		leitor.getEnderecos().add(endereco);

		return leitor;
	}
	
	private void updateData(Leitor newObj, Leitor obj) {
		newObj.setNome(obj.getNome());		
		newObj.setDataNascimento(obj.getDataNascimento());
		newObj.setStatus(obj.getStatus());
		newObj.getContato().setEmails(obj.getContato().getEmails());
		newObj.getContato().setTelefones(obj.getContato().getTelefones());
	}

}
