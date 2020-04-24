package com.codecool.recommendations.repository;

import com.codecool.recommendations.entity.RecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationsRepository extends JpaRepository<RecommendationEntity, Long> {

    List<RecommendationEntity> findAllByVideoId(Long videoId);
}
