package com.mobpro.mobpro_internal.dto;

import com.mobpro.mobpro_internal.entity.UserRole;

public record RegisterDTO(String username, String password, UserRole role) {
}
