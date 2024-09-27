package com.mobpro.mobpro_internal.persistence.repository;

import com.mobpro.mobpro_internal.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
}
