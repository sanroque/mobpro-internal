package com.mobpro.mobpro_internal.service.dto;

import com.mobpro.mobpro_internal.persistence.entity.Client;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClientDTO {

    private Long id;

    private String nif;

    private String name;

    private String address;

    private String zipcode;

    private String city;

    private String contact;

    private String phone;

    private String email;

    private String cellphone;

    private String observations;

    public ClientDTO(Client client) {
        BeanUtils.copyProperties(client, this);
        Assert.notNull(client, "Source must not be null");
        Assert.notNull(this, "Target must not be null");
    }
}
