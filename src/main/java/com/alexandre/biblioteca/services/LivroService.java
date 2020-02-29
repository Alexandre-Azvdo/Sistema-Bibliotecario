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

import com.alexandre.biblioteca.domain.Exemplar;
import com.alexandre.biblioteca.domain.Livro;
import com.alexandre.biblioteca.domain.dto.LivroDTO;
import com.alexandre.biblioteca.domain.dto.LivroNewDTO;
import com.alexandre.biblioteca.domain.enums.StatusLivro;
import com.alexandre.biblioteca.repositories.ExemplarRepository;
import com.alexandre.biblioteca.repositories.LivroRepository;
import com.alexandre.biblioteca.services.exceptions.DataIntegrityException;
import com.alexandre.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repo;
	@Autowired
	private ExemplarRepository exemplarRepository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}
	
	@Transactional
	public Livro insert(Livro obj) {
		obj.setId(null);
		obj = repo.save(obj);
		exemplarRepository.saveAll(obj.getExemplares());
		return obj;
	}
	
	public Livro update(Livro obj) {
		Livro newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Livro que está associados a um XXX!");
		}
	}
	
	public List<Livro> findAll(){
		return repo.findAll();
	}
	
	public Page<Livro> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Livro fromDTO(LivroDTO objDto) {
		return new Livro(objDto.getId(), objDto.getTitulo(), objDto.getSinopse(), objDto.getIsbn(), objDto.getEditora(), objDto.getGenero(), objDto.getIdioma(), objDto.getNumPaginas());
	}
	
	public Livro fromDTO(LivroNewDTO objDto) {
		Livro livro =  new Livro(null, objDto.getTitulo(), objDto.getSinopse(), objDto.getIsbn(), objDto.getEditora(), objDto.getGenero(), objDto.getIdioma(), objDto.getNumPaginas());
		Exemplar exemplar = new Exemplar(null, objDto.getIdentificador(), objDto.getQr_code(), objDto.getData_aquisicao(), objDto.getPreco_unitario(), StatusLivro.toEnum(objDto.getStatus()), objDto.getEdicao(), livro);
		livro.getExemplares().add(exemplar);
		
		return livro;
	}
	
	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setSinopse(obj.getSinopse());
		newObj.setIsbn(obj.getIsbn());
		newObj.setEditora(obj.getEditora());
		newObj.setGenero(obj.getGenero());
		newObj.setIdioma(obj.getIdioma());
		newObj.setNumPaginas(obj.getNumPaginas());
	}
}
