package com.alexandre.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alexandre.biblioteca.domain.Exemplar;
import com.alexandre.biblioteca.domain.Livro;
import com.alexandre.biblioteca.domain.dto.ExemplarDTO;
import com.alexandre.biblioteca.domain.enums.StatusLivro;
import com.alexandre.biblioteca.repositories.ExemplarRepository;
import com.alexandre.biblioteca.services.exceptions.DataIntegrityException;
import com.alexandre.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class ExemplarService {
	
	@Autowired
	private ExemplarRepository repo;
	
	public Exemplar findById(Integer id) {
		Optional<Exemplar> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Exemplar.class.getName()));
	}
	
	public Exemplar insert(Exemplar obj) {
		obj.setId(null);		
		return repo.save(obj);
	}
	
	public Exemplar update(Exemplar obj) {
		Exemplar  newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Exemplar que está associados a um livro!");
		}
	}
	
	public List<Exemplar> findAll(){
		return repo.findAll();
	}
	
	public Page<Exemplar> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Exemplar fromDto(ExemplarDTO objDto) {
		Livro livro = new Livro(objDto.getLivroId(), null, null, null, null, null, null, null);
		return new Exemplar(objDto.getId(), objDto.getIdentificador(), objDto.getQr_code(), objDto.getData_aquisicao(),
				objDto.getPreco_unitario(), StatusLivro.toEnum(objDto.getStatus()), objDto.getEdicao(), livro);
	}
	
	private void updateData(Exemplar newObj, Exemplar obj) {
		newObj.setIdentificador(obj.getIdentificador());
		newObj.setQr_code(obj.getQr_code());
		newObj.setData_aquisicao(obj.getData_aquisicao());
		newObj.setPreco_unitario(obj.getPreco_unitario());
		newObj.setStatus(obj.getStatus());
		newObj.setEdicao(obj.getEdicao());
		
	}
	
}
