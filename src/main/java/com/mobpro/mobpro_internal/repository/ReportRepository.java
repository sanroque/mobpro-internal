package com.mobpro.mobpro_internal.repository;

import com.mobpro.mobpro_internal.entity.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {
}
