package com.sajal48.gamehub.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class UserDto implements Serializable {
    private final String userName;
    private final String fullName;
    private final String password;
    private final String email;
    private final String phone;
    private final String Address;
    private final Collection<RoleDto> roles;
}
