package com.mobpro.mobpro_internal.service.service;

import com.mobpro.mobpro_internal.persistence.entity.Technician;
import com.mobpro.mobpro_internal.persistence.repository.TechnicianRepository;
import com.mobpro.mobpro_internal.service.dto.MaterialDTO;
import com.mobpro.mobpro_internal.service.dto.TechnicianDTO;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Service
public class TechnicianService {

    private final TechnicianRepository technicianRepository;

    public List<TechnicianDTO> getAll(){
        List<Technician> list = technicianRepository.findAll();
        return list.stream().map(TechnicianDTO::new).toList();
    }

    public TechnicianDTO getById(UUID id) throws Exception{
        Technician tech = technicianRepository.findById(id).orElse(null);
        if (null == tech) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Technician not found!");
        return new TechnicianDTO(tech);
    }

    public ResponseEntity<?> create(@NotNull TechnicianDTO data) throws Exception{
        Technician technician = new Technician(data);
        if (null != technicianRepository.findByNameAndSurname(data.getName(), data.getSurname()))
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Technician Already on database!");

        technicianRepository.save(technician);
        return ResponseEntity.ok("Technician " + technician.getName() +" "+ technician.getSurname()+ " created successfully!");
    }

    public ResponseEntity<TechnicianDTO> update(@NotNull TechnicianDTO data) throws Exception{
        Technician tech = technicianRepository.findById(data.getId()).orElse(null);
        if (null == tech) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Technician not found!");
        Technician updatedTech = new Technician(data);
        technicianRepository.save(updatedTech);
        return new ResponseEntity<>(new TechnicianDTO(updatedTech), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(UUID id){
       if (null != (technicianRepository.findById(id).orElse(null))){
           technicianRepository.deleteById(id);
           return ResponseEntity.ok("Technician deleted successfully!");
       }

        return null;
    }

}
