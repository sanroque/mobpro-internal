package com.mobpro.mobpro_internal.web.controller;


import com.mobpro.mobpro_internal.service.dto.TechnicianDTO;
import com.mobpro.mobpro_internal.service.service.TechnicianService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@RestController
@RequestMapping("/technicians")
public class TechnicianController {

    private final TechnicianService technicianService;

    @GetMapping
    public final List<TechnicianDTO> getAll(){
        return technicianService.getAll();
    }

    @GetMapping("/{id}")
    public final TechnicianDTO getById(@PathVariable("id") UUID id) throws Exception{
        return technicianService.getById(id);
    }

    @PostMapping
    public final ResponseEntity<?> create(@RequestBody TechnicianDTO data) throws Exception {
        return technicianService.create(data);
    }

    @PutMapping
    public final ResponseEntity<TechnicianDTO> update(@RequestBody TechnicianDTO data) throws Exception{
        return technicianService.update(data);
    }

    @DeleteMapping("/{id}")
    public final ResponseEntity<?> delete(@PathVariable("id") UUID uuid){
        return technicianService.delete(uuid);
    }
}
