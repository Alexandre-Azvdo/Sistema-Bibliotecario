package com.alexandre.biblioteca.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.alexandre.biblioteca.domain.Leitor;
import com.alexandre.biblioteca.domain.dto.LeitorDTO;
import com.alexandre.biblioteca.repositories.LeitorRepository;
import com.alexandre.biblioteca.resources.exceptions.FieldMessage;

public class LeitorUpdateValidator implements ConstraintValidator<LeitorUpdate, LeitorDTO>{

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private LeitorRepository repo;
	
	@Override
	public void initialize(LeitorUpdate ann) {

	}
	
	@Override
	public boolean isValid(LeitorDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Leitor aux = repo.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
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
