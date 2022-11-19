package com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    private String userName;
    private String password;
    private String email;
    private String role;
}

