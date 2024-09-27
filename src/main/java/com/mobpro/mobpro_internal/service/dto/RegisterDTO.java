package com.mobpro.mobpro_internal.service.dto;

import com.mobpro.mobpro_internal.persistence.entity.user.UserRole;

public record RegisterDTO(String username, String name, String surname, String password, UserRole role) {
}
