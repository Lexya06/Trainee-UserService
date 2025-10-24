package com.github.lexya.userservice.repository;

import com.github.lexya.userservice.model.CardInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CardInfoRepository extends JpaRepository<CardInfo,Long> {
    List<CardInfo> findByUserId(Long id);
    @Transactional
    @Modifying
    @Query(
            value = "DELETE FROM card_info WHERE card_user_id = :id",
            nativeQuery = true
    )
    int removeByUserId(@Param("id") Long id);
}
