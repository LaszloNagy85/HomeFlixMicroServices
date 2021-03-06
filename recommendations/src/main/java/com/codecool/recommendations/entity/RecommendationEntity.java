package com.codecool.recommendations.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RecommendationEntity {

    @GeneratedValue
    @Id
    private long id;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private String comment;

    @Column
    private long videoId;

    @Column(name = "creation_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime creationDate;
}
