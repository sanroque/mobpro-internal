package com.mobpro.mobpro_internal.persistence.repository;

import com.mobpro.mobpro_internal.persistence.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
