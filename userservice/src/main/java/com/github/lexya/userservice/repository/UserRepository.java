package com.github.lexya.userservice.repository;
import  com.github.lexya.userservice.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Modifying
    @Query(
        value = "INSERT INTO users (name, surname, birth_date, email) VALUES (:name, :surname, :birthDate, :email) RETURNING *",
        nativeQuery = true
    )
    Long addUserNative(@Param("name") String name,
                 @Param("surname") String surname,
                 @Param("birthDate")LocalDate birthDate,
                 @Param("email")  String email);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> getUserByIdJPQL(@Param("id") Long id);
    
    Optional<User> findUserByUserEmail(String email);


    @Modifying(clearAutomatically = true)
    @Query(
            value = "UPDATE users SET name = :name, surname = :surname, birth_date = :birthDate" +
                    ", email = :email WHERE id = :id" ,
            nativeQuery = true
    )
    int updateUserByIdNative(@Param("id") Long id,@Param("name") String name, @Param("surname") String surname, @Param("birthDate") LocalDate birthDate, @Param("email") String email);

    @Modifying(clearAutomatically = true)
    void removeUserById( Long id);

    // findAll embedded
}
