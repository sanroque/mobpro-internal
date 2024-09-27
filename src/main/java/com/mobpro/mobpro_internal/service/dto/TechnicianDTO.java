package com.mobpro.mobpro_internal.service.dto;

import com.mobpro.mobpro_internal.persistence.entity.Technician;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TechnicianDTO {

    private UUID id;
    private String name;
    private String surname;
    private Integer mechanographic;

    public TechnicianDTO(Technician data){
        BeanUtils.copyProperties(data, this);
    }


}
