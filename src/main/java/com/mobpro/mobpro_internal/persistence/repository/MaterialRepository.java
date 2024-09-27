package com.mobpro.mobpro_internal.persistence.repository;

import com.mobpro.mobpro_internal.persistence.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MaterialRepository extends JpaRepository<Material, UUID> {
    Material findByCode(String code);
}
