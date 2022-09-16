package com.sajal48.gamehub.service;

import com.sajal48.gamehub.entity.Role;
import com.sajal48.gamehub.repo.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role saveRole(Role role){
       return roleRepository.save(role);
    }

}
