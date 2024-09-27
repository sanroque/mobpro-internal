package com.mobpro.mobpro_internal.persistence.entity;

import com.mobpro.mobpro_internal.service.dto.MaterialDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
