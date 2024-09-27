package com.mobpro.mobpro_internal.persistence.repository;

import com.mobpro.mobpro_internal.persistence.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkRepository extends JpaRepository<Work, UUID> {
    Work findByNumber(String number);

}
