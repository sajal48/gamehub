package com.sajal48.gamehub.service;

import com.sajal48.gamehub.dto.UserDto;
import com.sajal48.gamehub.entity.Role;
import com.sajal48.gamehub.entity.User;
import com.sajal48.gamehub.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @Transactional
@Slf4j @RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private  final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;
    public User createNewUser(User user) {
        var roles = user.getRoles();
        var res = userRepository.save(user);
        return  res;
    }

    public void init(){
        Role role = new Role();
        role.setRoleName("admin");
        role.setRoleDescription("admin role");
        User user = new User();
        user.setUserName("sajal48");
        user.setPassword(passwordEncoder.encode("sajal48"));
        user.setEmail("a@gmail.com");
        user.getRoles().add(role);
        createNewUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();
        if(user == null){
            log.error("User not found in database");
            throw  new UsernameNotFoundException("User not found in database");
        }
        else{
            log.info("User {} found in database",username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getRoleName()));});
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
