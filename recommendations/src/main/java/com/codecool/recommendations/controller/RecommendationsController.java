package com.codecool.recommendations.controller;

import com.codecool.recommendations.entity.RecommendationEntity;
import com.codecool.recommendations.service.RecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videoId")
public class RecommendationsController {

    @Autowired
    private RecommendationsService recommendationsService;

    @GetMapping("/{videoId}")
    public List<RecommendationEntity> getRecommendationsByVideoId(@PathVariable Long videoId) {
        return recommendationsService.getRecommendationsByVideoId(videoId);
    }

}
