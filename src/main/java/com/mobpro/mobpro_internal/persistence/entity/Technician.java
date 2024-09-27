package com.mobpro.mobpro_internal.persistence.entity;

import com.mobpro.mobpro_internal.service.dto.TechnicianDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "technician")
@Table(name = "mp_technician")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String surname;
    private Integer mechanographic;

    public Technician(TechnicianDTO data){
        BeanUtils.copyProperties(data, this);
    }
}
