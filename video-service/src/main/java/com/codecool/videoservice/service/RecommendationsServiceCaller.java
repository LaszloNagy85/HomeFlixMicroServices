package com.codecool.videoservice.service;

import com.codecool.videoservice.model.VideoRecommendations;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class RecommendationsServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recommendations.url}")
    private String baseUrl;

    protected List<VideoRecommendations> getRecommendationsForVideo(long videoId){
//        List recommendationService = restTemplate.getForEntity(baseUrl + "/" + videoId, List.class).getBody();
//        ObjectMapper mapper = new ObjectMapper();
//        List<VideoRecommendations> recommendations = new ArrayList<>();
//
//        assert recommendationService != null;
//        for (Object each : recommendationService) {
//            recommendations.add(mapper.convertValue(each, VideoRecommendations.class));
//        }
//        return recommendations;

        ResponseEntity<VideoRecommendations[]> responseEntity = restTemplate.
                getForEntity(baseUrl + "/" + videoId, VideoRecommendations[].class);
            return Arrays.asList(responseEntity.getBody());
    };
}