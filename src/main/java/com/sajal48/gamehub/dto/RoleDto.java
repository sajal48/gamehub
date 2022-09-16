package com.sajal48.gamehub.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleDto implements Serializable {
    private final String roleName;
    private final String roleDescription;
}
