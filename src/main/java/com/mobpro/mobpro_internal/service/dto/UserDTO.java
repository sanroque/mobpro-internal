package com.mobpro.mobpro_internal.service.dto;

import com.mobpro.mobpro_internal.persistence.entity.user.User;
import com.mobpro.mobpro_internal.persistence.entity.user.UserRole;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserDTO {

    private Long id;
    private String login;
    private String name;
    private String surname;
    private String password;
    private UserRole role;

    public UserDTO(User user){
        BeanUtils.copyProperties(user, this);
    }
}
