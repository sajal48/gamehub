package com.sajal48.gamehub.repo;

import com.sajal48.gamehub.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}