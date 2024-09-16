package com.mobpro.mobpro_internal.entity.report;

import com.mobpro.mobpro_internal.dto.ReportDTO;
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
    private boolean cctv;
    private boolean ca;
    private boolean sdg;
    private boolean sadi;
    private boolean sadir;
    private String other;

    public Report(ReportDTO data){

        BeanUtils.copyProperties(data, this);
    }

}
