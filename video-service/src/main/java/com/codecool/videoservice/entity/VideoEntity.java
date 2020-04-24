package com.codecool.videoservice.entity;

import com.codecool.videoservice.model.VideoRecommendations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class VideoEntity {

    @GeneratedValue
    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    @Transient
    private List<VideoRecommendations> recommendations;

}
