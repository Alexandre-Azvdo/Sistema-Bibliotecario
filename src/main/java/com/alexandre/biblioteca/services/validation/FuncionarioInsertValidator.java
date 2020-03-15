package com.alexandre.biblioteca.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexandre.biblioteca.domain.Funcionario;
import com.alexandre.biblioteca.domain.dto.FuncionarioNewDTO;
import com.alexandre.biblioteca.repositories.FuncionarioRepository;
import com.alexandre.biblioteca.resources.exceptions.FieldMessage;

public class FuncionarioInsertValidator implements ConstraintValidator<FuncionarioInsert, FuncionarioNewDTO>{

	@Autowired
	private FuncionarioRepository repo;
	
	@Override
	public void initialize(FuncionarioInsert ann) {

	}
	
	@Override
	public boolean isValid(FuncionarioNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Funcionario aux = repo.findByEmail(objDto.getEmail());
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
