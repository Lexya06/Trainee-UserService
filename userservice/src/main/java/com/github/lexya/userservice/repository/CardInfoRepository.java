package com.github.lexya.userservice.repository;
import com.github.lexya.userservice.model.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface CardInfoRepository extends JpaRepository<CardInfo,Long> {
    // create card with save

    @Query(value = "SELECT * FROM card_info WHERE id = :id",nativeQuery = true)
    Optional<CardInfo> findCardInfoById(Long id);

    // pagination with findAll

    List<CardInfo> findCardInfoByUserId(Long id);

    // update card by id with mapping

    // update active with mapping

    // count user cards quickly
    long countCardInfoByUserId(Long id);

}
