package com.alexandre.biblioteca.domain.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


public class CustomerDateAndTimeDeserialize extends JsonDeserializer<Date> {
	
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
		throws IOException, JsonProcessingException {
	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    String date = jp.getText();

	    try {
	    	return format.parse(date);
	    } catch (ParseException e) {
	        throw new RuntimeException(e);
	    }
	}
}