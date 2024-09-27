package com.mobpro.mobpro_internal.persistence.entity.report;

import com.mobpro.mobpro_internal.service.dto.ReportDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "report")
@Table(name = "mp_report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private String missing;
    private Integer cctv; // Changed from int to Integer
    private Integer ca;    // Changed from int to Integer
    private Integer sdg;   // Changed from int to Integer
    private Integer sadi;  // Changed from int to Integer
    private Integer sadir; // Changed from int to Integer
    private String other;

    public Report(ReportDTO data) {
        BeanUtils.copyProperties(data, this);
    }
}