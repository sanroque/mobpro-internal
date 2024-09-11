package com.mobpro.mobpro_internal.entity;

import com.mobpro.mobpro_internal.dto.ClientDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "client")
@Table(name = "mp_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Client(ClientDTO dto){
        BeanUtils.copyProperties(dto, this);
    }
}
