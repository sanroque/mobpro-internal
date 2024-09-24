package com.mobpro.mobpro_internal.service;

import com.mobpro.mobpro_internal.dto.MaterialDTO;
import com.mobpro.mobpro_internal.entity.Material;
import com.mobpro.mobpro_internal.repository.MaterialRepository;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private HttpSession httpSession;

    public List<MaterialDTO> getAll() throws Exception{
        List<Material> list = materialRepository.findAll();
        if (list.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "List is empty");
        return list.stream().map(MaterialDTO::new).toList();
    }

    public ResponseEntity<MaterialDTO> getById(UUID id) throws Exception{
        Material material = materialRepository.findById(id).orElse(null);
        if (material == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Material not found!");

        return new ResponseEntity<>(new MaterialDTO(material), HttpStatus.OK);
    }

    public ResponseEntity<MaterialDTO> save(@NotNull MaterialDTO dto) throws Exception{
        Material material = new Material(dto);
        if (materialRepository.findByCode(dto.getCode()) != null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE,
                    "Material code already on database!"
            );
        }


        materialRepository.save(material);
        return ResponseEntity.ok(new MaterialDTO(material));
    }

    public ResponseEntity<MaterialDTO> update(@NotNull UUID id, @NotNull MaterialDTO dto) throws Exception{
        Material material = materialRepository.findById(id).orElse(null);
        if (material == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Material not found!");

        Material updatedMaterial = new Material(dto);
        materialRepository.save(updatedMaterial);
        return new ResponseEntity<>(new MaterialDTO(updatedMaterial), HttpStatus.OK);
    }

    public ResponseEntity<MaterialDTO> delete(@NotNull UUID id) throws Exception{
        Material material = materialRepository.findById(id).orElse(null);
        if (material == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Material not found");
        materialRepository.delete(material);
        return new ResponseEntity<>(new MaterialDTO(material), HttpStatus.GONE );
    }
}
