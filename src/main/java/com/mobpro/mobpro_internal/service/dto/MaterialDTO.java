package com.mobpro.mobpro_internal.service.dto;

import com.mobpro.mobpro_internal.persistence.entity.Material;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MaterialDTO {

    private UUID id;
    private String code;
    private String name;
    private String description;
    private Integer quantity;


    public MaterialDTO(Material data){
        BeanUtils.copyProperties(data, this);
    }
}
