package com.mobpro.mobpro_internal.dto;

import com.mobpro.mobpro_internal.entity.user.UserRole;

public record RegisterDTO(String username, String name, String surname, String password, UserRole role) {
}
