package com.mobpro.mobpro_internal.persistence.repository;

import com.mobpro.mobpro_internal.persistence.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TechnicianRepository extends JpaRepository<Technician, UUID> {
    Technician findByNameAndSurname(String name, String surname);
}
