package com.sajal48.gamehub.repo;

import com.sajal48.gamehub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}