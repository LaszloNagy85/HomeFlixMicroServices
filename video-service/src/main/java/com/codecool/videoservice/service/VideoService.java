package com.codecool.videoservice.service;

import com.codecool.videoservice.entity.VideoEntity;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<VideoEntity> listAllVideos() {
        System.out.println(videoRepository.findAll());
        return videoRepository.findAll();
    }
}
