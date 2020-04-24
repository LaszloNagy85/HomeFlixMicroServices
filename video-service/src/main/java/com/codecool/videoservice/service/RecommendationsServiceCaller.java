package com.codecool.videoservice.service;

import com.codecool.videoservice.model.VideoRecommendations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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
//        assert recommendationService != null;
//        for (Object each : recommendationService) {recommendations.add(mapper.convertValue(each, VideoRecommendations.class));        }
//        return recommendations;

        ResponseEntity<VideoRecommendations[]> responseEntity = restTemplate.
                getForEntity(baseUrl + "/videoId/" + videoId, VideoRecommendations[].class);
            return Arrays.asList(responseEntity.getBody());
    };

    protected void saveNewRecommendation(VideoRecommendations videoRecommendation) {
        restTemplate.postForEntity(baseUrl + "/save", videoRecommendation, VideoRecommendations.class);
    }

    protected void updateRecommendation(VideoRecommendations videoRecommendation) {
        restTemplate.put(baseUrl + "/update", videoRecommendation, VideoRecommendations.class);
    }
}