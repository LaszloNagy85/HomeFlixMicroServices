package com.codecool.recommendations.repository;

import com.codecool.recommendations.entity.RecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecommendationsRepository extends JpaRepository<RecommendationEntity, Long> {

    List<RecommendationEntity> findAllByVideoIdOrderByCreationDateDesc(Long videoId);

    @Transactional
    @Modifying
    @Query("UPDATE RecommendationEntity r SET r.rating = :rating, r.comment= :comment WHERE r.id = :id ")
    void updateRecommendation(@Param("id") Long recommendationId,
                              @Param("rating") int rating,
                              @Param("comment") String comment);
}
