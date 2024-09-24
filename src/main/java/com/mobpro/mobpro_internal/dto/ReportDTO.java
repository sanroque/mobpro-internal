package com.mobpro.mobpro_internal.dto;
import com.mobpro.mobpro_internal.entity.report.Report;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ReportDTO {

    private UUID id;
    private String description;
    private String missing;
    private Integer cctv; // Changed from int to Integer
    private Integer ca;    // Changed from int to Integer
    private Integer sdg;   // Changed from int to Integer
    private Integer sadi;  // Changed from int to Integer
    private Integer sadir; // Changed from int to Integer
    private String other;

    public ReportDTO(Report data) {
        BeanUtils.copyProperties(data, this);
    }
}