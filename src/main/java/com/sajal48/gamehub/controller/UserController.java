package com.sajal48.gamehub.controller;

import com.sajal48.gamehub.dto.RoleDto;
import com.sajal48.gamehub.dto.UserDto;
import com.sajal48.gamehub.entity.User;
import com.sajal48.gamehub.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping({"/gh/api"})
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private  final BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
        userService.init();
    }

    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody UserDto userDto){
        User user = new User();


        User response = userService.createNewUser(user);
        return  response;
    }
    @PostMapping("/test")
    public User test(@RequestBody UserDto test){
        User user = new User();
        modelMapper.map(test,user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info(user.toString());
        User response = userService.createNewUser(user);
        return  response;

    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
