package com.mobpro.mobpro_internal.dto;

import com.mobpro.mobpro_internal.entity.Work;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class WorkDTO {

    private UUID id;
    private String number;
    private String numPAD;
    private String address;


    public WorkDTO(@NotNull Work data){
        this.id = data.getId();
        this.number = data.getNumber();
        this.numPAD = data.getNumPAD();
        this.address = data.getAddress();
    }
}
