package com.codecool.recommendations.service;

import com.codecool.recommendations.entity.RecommendationEntity;
import com.codecool.recommendations.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationsService {

    @Autowired
    private RecommendationsRepository recommendationsRepository;

    public List<RecommendationEntity> getRecommendationsByVideoId(Long videoId) {
        List <RecommendationEntity> result = recommendationsRepository.findAllByVideoIdOrderByCreationDateDesc(videoId);
        return result == null? new ArrayList<>() : result;
    }

    public void saveNewRecommendation(RecommendationEntity recommendationEntity) {
        recommendationEntity.setCreationDate(LocalDateTime.now());
        recommendationsRepository.save(recommendationEntity);
    }

    public void updateRecommendation(RecommendationEntity recommendationEntity) {
        recommendationsRepository.updateRecommendation(
                recommendationEntity.getId(),
                recommendationEntity.getRating(),
                recommendationEntity.getComment());
    }
}
