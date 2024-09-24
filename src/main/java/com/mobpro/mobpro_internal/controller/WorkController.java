package com.mobpro.mobpro_internal.controller;

import com.mobpro.mobpro_internal.dto.WorkDTO;
import com.mobpro.mobpro_internal.service.work.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/works")
public class WorkController {

    @Autowired
    private WorkService workService;

    @GetMapping
    public ResponseEntity<List<WorkDTO>> listAll(){
        return ResponseEntity.ok(workService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(workService.getById(id));
    }

    @PostMapping
    public ResponseEntity<WorkDTO> create(@RequestBody WorkDTO workDTO){
        workService.save(workDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkDTO> update(@PathVariable UUID id, @RequestBody WorkDTO workDTO){
        return workService.update(id, workDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        workService.delete(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }


}
