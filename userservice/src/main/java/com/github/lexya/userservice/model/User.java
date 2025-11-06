package com.github.lexya.userservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="users")
public class User extends BaseEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false, name="name")
    private String userName;

    @Getter
    @Setter
    @Column(name = "surname")
    private String userSurname;

    @Getter
    @Setter
    @Column(nullable = false, name = "birth_date")
    private LocalDate userBirthday;

    @Getter
    @Setter
    @Column(nullable = false, name= "email", unique = true, length = 254)
    private String userEmail;

    @Getter
    @Setter
    @Column(nullable = false, name = "active")
    private boolean isUserActive;
}
