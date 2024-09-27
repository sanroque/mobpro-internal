package com.mobpro.mobpro_internal.service.service;

import com.mobpro.mobpro_internal.service.dto.ReportDTO;
import com.mobpro.mobpro_internal.persistence.entity.report.Report;
import com.mobpro.mobpro_internal.persistence.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ResponseEntity<List<ReportDTO>> getAll(){
        List<Report> reports = reportRepository.findAll();
        return ResponseEntity.ok(reports.stream().map(ReportDTO::new).toList());
    }

    public ResponseEntity<String> add(ReportDTO data){
        Report report = new Report(data);
        reportRepository.save(report);
        return ResponseEntity.ok("Report added");
    }

    public ResponseEntity<ReportDTO> update(ReportDTO data){
        Report report = reportRepository.getById(data.getId());

        if(report != null){
            Report updatedReport = new Report(data);
            reportRepository.save(updatedReport);
            return ResponseEntity.ok(new ReportDTO(updatedReport));
        }

        return null;
    }

    public ResponseEntity<?> delete(UUID id){
        Report report = reportRepository.getById(id);
        if(report != null){
            reportRepository.deleteById(id);
            return ResponseEntity.accepted().build();
        }

        return null;
    }

}
