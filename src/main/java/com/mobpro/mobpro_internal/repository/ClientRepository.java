package com.mobpro.mobpro_internal.repository;

import com.mobpro.mobpro_internal.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
}
