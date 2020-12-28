package com.apirest.dsbank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.dsbank.entities.Cliente;
import com.apirest.dsbank.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Transactional (readOnly = true)	
	public List<Cliente> findAll() {
		return repository.findAll();
		
	}

}
