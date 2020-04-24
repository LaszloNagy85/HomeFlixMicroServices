package com.codecool.videoservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class VideoRecommendations {
    private long id;
    private long rating;
    private String comment;
    private long videoId;
    private LocalDate creationDate;
}
