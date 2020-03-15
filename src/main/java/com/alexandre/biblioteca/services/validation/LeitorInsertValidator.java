package com.alexandre.biblioteca.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexandre.biblioteca.domain.Leitor;
import com.alexandre.biblioteca.domain.dto.LeitorNewDTO;
import com.alexandre.biblioteca.repositories.LeitorRepository;
import com.alexandre.biblioteca.resources.exceptions.FieldMessage;

public class LeitorInsertValidator implements ConstraintValidator<LeitorInsert, LeitorNewDTO>{

	@Autowired
	private LeitorRepository repo;
	
	@Override
	public void initialize(LeitorInsert ann) {

	}
	
	@Override
	public boolean isValid(LeitorNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Leitor aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
				.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
