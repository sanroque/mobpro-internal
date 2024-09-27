package com.mobpro.mobpro_internal.service.service.work;

import com.mobpro.mobpro_internal.service.dto.WorkDTO;
import com.mobpro.mobpro_internal.persistence.entity.Work;
import com.mobpro.mobpro_internal.persistence.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkService {

    @Autowired
    private  WorkRepository workRepository;

    public List<WorkDTO> listAll(){
        List<Work> list = workRepository.findAll();
        return list.stream().map(WorkDTO::new).toList();
    }

    public WorkDTO getById(UUID id){
        Work work = workRepository.findById(id).orElse(null);
        return new WorkDTO(work);
    }

    public void save(WorkDTO workDTO){
        PadGeneration padGen = new PadGeneration();
        Work work = new Work(workDTO);
        var verification = workRepository.findByNumber(work.getNumber());
        if (verification == null){
            work.setNumPAD(padGen.getNumPAD());
            workRepository.save(work);
        }
    }
    public ResponseEntity<WorkDTO> update( UUID uuid, WorkDTO workDTO){
        Work work = workRepository.findById(uuid).orElse(null);
        Work newWork = new Work(workDTO);
        if(work != null){
            workRepository.save(newWork);
            return new ResponseEntity(HttpStatus.ACCEPTED, HttpStatus.OK);
        }
        return null;
    }

    public void delete(UUID id){
        Optional<Work> workOptional = workRepository.findById(id);
        if (workOptional.isPresent()) {
            Work work = workOptional.get();
            workRepository.delete(work);
        }
    }
}
