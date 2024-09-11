package com.mobpro.mobpro_internal.service;


import com.mobpro.mobpro_internal.dto.ClientDTO;
import com.mobpro.mobpro_internal.entity.Client;
import com.mobpro.mobpro_internal.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(ClientDTO::new).toList();
    }

    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        return new ClientDTO(client);
    }

    public void addClient(ClientDTO dto) {
        Client client = new Client(dto);
        clientRepository.save(client);
    }


    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}

