package com.sajal48.gamehub.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    private String userName;
    private String fullName;
    private String password;
    private String email;
    private String phone;
    private String Address;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<Role> roles = new ArrayList<>();
}
