package com.codecool.recommendations.controller;

import com.codecool.recommendations.entity.RecommendationEntity;
import com.codecool.recommendations.service.RecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RecommendationsController {

    @Autowired
    private RecommendationsService recommendationsService;

    @GetMapping("/videoId/{videoId}")
    public List<RecommendationEntity> getRecommendationsByVideoId(@PathVariable Long videoId) {
        return recommendationsService.getRecommendationsByVideoId(videoId);
    }

    @PostMapping("/save")
    public void saveNewRecommendation(@Valid @RequestBody RecommendationEntity recommendationEntity) {
        recommendationsService.saveNewRecommendation(recommendationEntity);
    }
}
