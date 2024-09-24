package com.mobpro.mobpro_internal.entity;

import com.mobpro.mobpro_internal.dto.WorkDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "work")
@Table(name = "mp_work")
public class Work {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String number;
    private String numPAD;
    private String address;

    public Work(WorkDTO data){
        BeanUtils.copyProperties(data, this);
    }

    public Work(UUID id, WorkDTO data){
        this.id = id;
        this.number = data.getNumber();
        this.numPAD = data.getNumPAD();
        this.address = data.getAddress();
    }
}
