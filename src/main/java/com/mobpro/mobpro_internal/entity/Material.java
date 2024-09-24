package com.mobpro.mobpro_internal.entity;

import com.mobpro.mobpro_internal.dto.MaterialDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity(name = "material")
@Table(name = "mp_material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String code;
    private String name;
    private String description;
    private Integer quantity;

    public Material(MaterialDTO data) {
        BeanUtils.copyProperties(data, this);
    }
}
