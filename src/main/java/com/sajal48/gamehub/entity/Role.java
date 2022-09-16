package com.sajal48.gamehub.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Role {
    @Id
    private String roleName;
    private String roleDescription;
}
