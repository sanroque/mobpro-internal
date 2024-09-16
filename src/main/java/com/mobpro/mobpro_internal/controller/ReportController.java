package com.mobpro.mobpro_internal.controller;


import com.mobpro.mobpro_internal.dto.ReportDTO;
import com.mobpro.mobpro_internal.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<ReportDTO> getAll(){
        //return ResponseEntity.ok(reportService.getAll()).getBody();
        return reportService.getAll().getBody();
    }

    @PostMapping
    public void add(ReportDTO data){
        reportService.add(data);
    }
}
