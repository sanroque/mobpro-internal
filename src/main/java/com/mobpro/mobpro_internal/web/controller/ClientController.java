package com.mobpro.mobpro_internal.web.controller;

import com.mobpro.mobpro_internal.service.dto.ClientDTO;
import com.mobpro.mobpro_internal.service.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@RestController
@RequestMapping("/clients")
@CrossOrigin
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<ClientDTO> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PostMapping
    public void createClient(@RequestBody ClientDTO clientDTO) {
        clientService.addClient(clientDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO data){
        return clientService.updateClient(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
