package com.mobpro.mobpro_internal.persistence.repository;

import com.mobpro.mobpro_internal.persistence.entity.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {
}
