package com.example.usersapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "user")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

}
