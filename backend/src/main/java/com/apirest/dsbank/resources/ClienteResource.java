package com.apirest.dsbank.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.dsbank.dto.ClienteDTO;
import com.apirest.dsbank.services.ClienteService;

@RestController
@RequestMapping (value = "/clientes")
public class ClienteResource {
	
	@Autowired	
	private ClienteService service;
	
	// Primeiro end point da aplicação
		@GetMapping // annotation para configurar que este método seja um web service
		public ResponseEntity<List<ClienteDTO>> findAll() {
			List<ClienteDTO> list = service.findAll();	
			return ResponseEntity.ok().body(list);		
		
	
	}
		
		// Criando End Point para buscar Cliente por id - GET
		@GetMapping(value = "/{id}")
		public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {

			ClienteDTO dto = service.findById(id);
			return ResponseEntity.ok().body(dto);

		}
		
		

}

