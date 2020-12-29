package com.apirest.dsbank.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.dsbank.dto.ClienteDTO;
import com.apirest.dsbank.entities.Cliente;
import com.apirest.dsbank.repositories.ClienteRepository;
import com.apirest.dsbank.services.exceptions.EntityNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Transactional (readOnly = true)	
	public List<ClienteDTO> findAll() {
		List<Cliente> list = repository.findAll();
		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
		
	}
	
	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		Cliente entity = obj.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
		return new ClienteDTO(entity);
	}
	
	

}
