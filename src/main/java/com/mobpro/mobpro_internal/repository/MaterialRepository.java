package com.mobpro.mobpro_internal.repository;

import com.mobpro.mobpro_internal.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MaterialRepository extends JpaRepository<Material, UUID> {
    Material findByCode(String code);
}
