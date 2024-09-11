package com.mobpro.mobpro_internal.dto;

import com.mobpro.mobpro_internal.entity.User;
import com.mobpro.mobpro_internal.entity.UserRole;
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
    private String password;
    private UserRole role;

    public UserDTO(User user){
        BeanUtils.copyProperties(user, this);
    }
}
