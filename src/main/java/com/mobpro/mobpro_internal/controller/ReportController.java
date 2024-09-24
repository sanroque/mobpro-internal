package com.mobpro.mobpro_internal.controller;


import com.mobpro.mobpro_internal.dto.ReportDTO;
import com.mobpro.mobpro_internal.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<ReportDTO> getAll(){
        //return ResponseEntity.ok(reportService.getAll()).getBody();
        return reportService.getAll().getBody();
    }

    @PostMapping
    public void add(@RequestBody ReportDTO data){
        reportService.add(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ReportDTO data){
        return reportService.update(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        return reportService.delete(id);
    }
}
