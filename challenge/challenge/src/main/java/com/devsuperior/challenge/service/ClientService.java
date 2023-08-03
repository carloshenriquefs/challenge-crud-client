package com.devsuperior.challenge.service;

import com.devsuperior.challenge.dto.ClientDTO;
import com.devsuperior.challenge.entities.Client;
import com.devsuperior.challenge.repositories.ClientRepository;
import com.devsuperior.challenge.service.exceptions.DatabaseException;
import com.devsuperior.challenge.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.devsuperior.challenge.constants.Constants.FALHA_INTEGRIDADE_REFERENCIAL;
import static com.devsuperior.challenge.constants.Constants.RECURSO_NAO_ENCONTRADO;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(RECURSO_NAO_ENCONTRADO));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client client = new Client();
        copyDtoToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException(RECURSO_NAO_ENCONTRADO);
        }
        try {
            clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(FALHA_INTEGRIDADE_REFERENCIAL);
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
    }

}
