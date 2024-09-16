package com.mobpro.mobpro_internal.service;

import com.mobpro.mobpro_internal.dto.ReportDTO;
import com.mobpro.mobpro_internal.entity.report.Report;
import com.mobpro.mobpro_internal.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public ResponseEntity<List<ReportDTO>> getAll(){
        List<Report> reports = reportRepository.findAll();
        return ResponseEntity.ok(reports.stream().map(ReportDTO::new).toList());
    }

    public ResponseEntity<String> add(ReportDTO data){
        Report report = new Report(data);
        reportRepository.save(report);
        return ResponseEntity.ok("User created sucessfully");
    }


}
