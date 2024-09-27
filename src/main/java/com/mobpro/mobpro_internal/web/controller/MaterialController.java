package com.mobpro.mobpro_internal.web.controller;

import com.mobpro.mobpro_internal.service.dto.MaterialDTO;
import com.mobpro.mobpro_internal.service.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@RestController
@RequestMapping("/materials")
public class MaterialController {


    private final MaterialService materialService;

    @GetMapping
    public List<MaterialDTO> getAll() throws Exception {
        return materialService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDTO> getById(@PathVariable UUID id) throws Exception {
        return materialService.getById(id);
    }

    @PostMapping
    public ResponseEntity<MaterialDTO> create(@RequestBody MaterialDTO materialDTO) throws Exception {
        return materialService.save(materialDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDTO> update(@PathVariable UUID id, @RequestBody MaterialDTO materialDTO) throws Exception {
        return materialService.update(id, materialDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) throws Exception {
        return materialService.delete(id);
    }
}
