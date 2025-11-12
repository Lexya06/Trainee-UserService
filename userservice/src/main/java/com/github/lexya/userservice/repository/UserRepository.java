package com.github.lexya.userservice.repository;
import  com.github.lexya.userservice.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // insert user by save method

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.cards  WHERE u.id = :id")
    Optional<User> findUserById(@Param("id") Long id);

    // findAll for pagination and with specification
    @EntityGraph("cards")
    Page<User> findAll(Specification<User> spec, Pageable pageable);

    // update by id with save method





}
