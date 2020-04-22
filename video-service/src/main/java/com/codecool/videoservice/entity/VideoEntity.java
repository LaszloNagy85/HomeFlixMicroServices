package com.codecool.videoservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}
