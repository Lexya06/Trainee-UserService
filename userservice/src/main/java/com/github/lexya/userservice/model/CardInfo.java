package com.github.lexya.userservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="card_info")
public class CardInfo extends BaseEntity {
    @Getter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(nullable = false, name="card_user_id")
    private User user;

    @Getter
    @Setter
    @Column(nullable = false, name="number", length = 19, unique = true)
    private String cardNumber;

    @Getter
    @Setter
    @Column(name="card_holder", nullable = false)
    private String holder;

    @Getter
    @Column(nullable = false, name="expiration_date")
    private String expirationDate;

    @Getter
    @Setter
    @Column(nullable = false, name = "active")
    private boolean isCardActive;
}
