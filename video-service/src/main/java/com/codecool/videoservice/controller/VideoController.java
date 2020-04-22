package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.VideoEntity;
import com.codecool.videoservice.service.VideoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
