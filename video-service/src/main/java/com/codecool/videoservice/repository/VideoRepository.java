package com.codecool.videoservice.repository;

import com.codecool.videoservice.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
}
