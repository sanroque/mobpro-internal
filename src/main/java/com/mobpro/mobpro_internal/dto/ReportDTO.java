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
    private boolean cctv;
    private boolean ca;
    private boolean sdg;
    private boolean sadi;
    private boolean sadir;
    private String other;

    public ReportDTO(Report data){
        BeanUtils.copyProperties(data, this);
    }
}
