package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.VideoEntity;
import com.codecool.videoservice.model.VideoRecommendations;
import com.codecool.videoservice.service.VideoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/list")
    @ApiOperation(value = "Getting full list of videos!")
    public List<VideoEntity> listAllVideos() {
        return videoService.listAllVideos();
    }

    @GetMapping("/video/{videoId}")
    @ApiOperation(value = "Get video by id with it's recommendations!")
    public VideoEntity getVideoByIdWithRecommendations(@PathVariable Long videoId) {
        return videoService.getVideoByIdWithRecommendations(videoId);
    }

    @PutMapping("/video/update")
    @ApiOperation(value = "Update details of an existing video.")
    public void updateVideo(@Valid @RequestBody VideoEntity videoEntity) {
        videoService.updateVideo(videoEntity);
    }

    @PostMapping("/save-new-recommendation")
    @ApiOperation("Saving a new recommendation!")
    public void saveNewRecommendation(@Valid @RequestBody VideoRecommendations videoRecommendation) {
        videoService.saveNewRecommendation(videoRecommendation);
    }

    @PutMapping("/update-recommendation")
    @ApiOperation("Updating an existing recommendation!")
    public void updateRecommendation(@Valid @RequestBody VideoRecommendations videoRecommendation) {
        videoService.updateRecommendation(videoRecommendation);
    }
}
