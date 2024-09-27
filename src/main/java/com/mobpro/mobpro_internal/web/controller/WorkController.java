package com.mobpro.mobpro_internal.web.controller;

import com.mobpro.mobpro_internal.service.dto.WorkDTO;
import com.mobpro.mobpro_internal.service.service.work.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@RestController
@RequestMapping("/works")
public class WorkController {

    private final WorkService workService;

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
