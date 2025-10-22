package com.github.lexya.userservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name="name")
    private String userName;

    @Column(nullable = true, name = "surname")
    private String userSurname;

    @Column(nullable = false, name = "birth_date")
    private LocalDate userBirthday;

    @Column(nullable = false, name= "email", unique = true, length = 254)
    private String userEmail;
}
