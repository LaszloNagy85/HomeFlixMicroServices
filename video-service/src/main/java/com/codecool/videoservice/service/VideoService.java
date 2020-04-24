package com.codecool.videoservice.service;

import com.codecool.videoservice.entity.VideoEntity;
import com.codecool.videoservice.model.VideoRecommendations;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private RecommendationsServiceCaller recommendationsServiceCaller;


    public List<VideoEntity> listAllVideos() {
        System.out.println(videoRepository.findAll());
        return videoRepository.findAll();
    }

    public VideoEntity getVideoByIdWithRecommendations(Long videoId) {
        Optional<VideoEntity> videoEntity = videoRepository.findById(videoId);
        videoEntity.ifPresent(entity -> entity.setRecommendations(recommendationsServiceCaller.getRecommendationsForVideo(videoId)));
        return videoEntity.orElse(VideoEntity.builder().name("No Video Recorder with this ID yet").build());
    }

    public void saveNewRecommendation(VideoRecommendations videoRecommendation) {
        recommendationsServiceCaller.saveNewRecommendation(videoRecommendation);
    }
}
