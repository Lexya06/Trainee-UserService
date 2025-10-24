package com.github.lexya.userservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name="card_info")
public class CardInfo {
    @Getter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Getter
    @ManyToOne
    @JoinColumn(name="card_user_id", nullable = true)
    private User user;

    @Getter
    @Setter
    @Column(nullable = false, name="number", length = 19, unique = true)
    private String cardNumber;

    @Getter
    @ManyToOne
    @JoinColumn(name="card_holder_id",  nullable = true)
    private User holder;

    @Getter
    @Column(name="expiration_date")
    private OffsetDateTime expirationDate;
}
