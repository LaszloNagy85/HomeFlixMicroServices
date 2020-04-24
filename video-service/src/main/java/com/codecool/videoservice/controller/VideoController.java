package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.VideoEntity;
import com.codecool.videoservice.service.VideoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/list")
    @ApiOperation(value = "Getting full list of videos!")
    public List<VideoEntity> listAllVideos() {
        return videoService.listAllVideos();
    }

    @GetMapping("/{videoId}")
    @ApiOperation(value = "Get video by id with it's recommendations!")
    public VideoEntity getVideoByIdWithRecommendations(@PathVariable Long videoId) {
        return videoService.getVideoByIdWithRecommendations(videoId);
    }
}
