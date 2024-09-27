package com.mobpro.mobpro_internal.service.service;


import com.mobpro.mobpro_internal.service.dto.ClientDTO;
import com.mobpro.mobpro_internal.persistence.entity.Client;
import com.mobpro.mobpro_internal.persistence.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public List<ClientDTO> getClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(ClientDTO::new).toList();
    }

    public ResponseEntity<ClientDTO> getClient(Long id) {
        return clientRepository.findById(id)
                .map(ClientDTO::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> addClient(ClientDTO dto) {
        Client client = new Client(dto);
        clientRepository.save(client);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<ClientDTO> updateClient(ClientDTO data){
        Client client = new Client(data);
        clientRepository.save(client);
        return ResponseEntity.ok().body(new ClientDTO(client));
    }


    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}

