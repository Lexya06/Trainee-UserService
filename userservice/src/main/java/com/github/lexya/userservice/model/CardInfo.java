package com.github.lexya.userservice.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name="card_info")
public class CardInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="card_user_id", nullable = true)
    private User user;

    @Column(nullable = false, name="number", length = 19, unique = true)
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name="card_holder_id",  nullable = true)
    private User holder;

    @Column(name="expiration_date")
    private OffsetDateTime expirationDate;
}
