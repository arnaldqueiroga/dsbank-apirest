package com.apirest.dsbank.resources.exceptions;



import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.apirest.dsbank.services.exceptions.ResourceNotFoundException;

@ControllerAdvice // Anotation que irá permitir que a classe intercepte alguma exceção que aconteça na camada
//de Resource (controlador Rest), para tratar a exceção

public class ResourcesExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErroPadrao> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		ErroPadrao err = new ErroPadrao();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Recurso não encontrado");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	
		
		
	}

}
