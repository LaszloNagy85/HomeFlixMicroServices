package com.codecool.videoservice.repository;

import com.codecool.videoservice.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE VideoEntity v SET v.name = :name, v.url = :url WHERE v.id = :id")
    void updateVideo(@Param("id") long id, @Param("name") String name, @Param("url") String url);
}
