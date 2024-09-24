package com.mobpro.mobpro_internal.dto;

import com.mobpro.mobpro_internal.entity.Material;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
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
