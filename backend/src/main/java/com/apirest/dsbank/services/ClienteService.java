package com.apirest.dsbank.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.dsbank.dto.ClienteDTO;
import com.apirest.dsbank.entities.Cliente;
import com.apirest.dsbank.repositories.ClienteRepository;
import com.apirest.dsbank.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() {
		List<Cliente> list = repository.findAll();
		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());

	}

	// Método para busca
	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		Cliente entity = obj.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
		return new ClienteDTO(entity);
	}

	// Método Insert (inserir)
	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		Cliente entity = new Cliente();
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setdataDeNascimento(dto.getDataDeNascimento());
		entity = repository.save(entity);
		return new ClienteDTO(entity);

	}

	// Método update (Atualizar)
	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		try {
			Cliente entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			entity.setEmail(dto.getEmail());
			entity.setCpf(dto.getCpf());
			entity.setdataDeNascimento(dto.getDataDeNascimento());
			entity = repository.save(entity);
			return new ClienteDTO(entity);
			
		}	
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(" Id não encontrado " +  id );
			
		}
		

	}

}
