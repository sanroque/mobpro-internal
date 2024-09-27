package com.mobpro.mobpro_internal.persistence.entity.user;


import com.mobpro.mobpro_internal.persistence.entity.Client;
import com.mobpro.mobpro_internal.persistence.entity.Work;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "work_identification")
public class WorkIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String workNumber;
    private String clientName;
    private String address;
    private String numPAD;

    public WorkIdentification(String workNumber, String clientName, String address, String numPAD) {
        this.workNumber = workNumber;
        this.clientName = clientName;
        this.address = address;
        this.numPAD = numPAD;
    }
}
