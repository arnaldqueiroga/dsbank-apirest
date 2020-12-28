package com.apirest.dsbank.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.dsbank.entities.Cliente;
import com.apirest.dsbank.services.ClienteService;

@RestController
@RequestMapping (value = "/clientes")
public class ClienteResource {
	
	@Autowired	
	private ClienteService service;
	
	// Primeiro end point da aplicação
		@GetMapping // annotation para configurar que este método seja um web service
		public ResponseEntity<List<Cliente>> findAll() {
			List<Cliente> list = service.findAll();	
			return ResponseEntity.ok().body(list);
			
		
	
	}

}
