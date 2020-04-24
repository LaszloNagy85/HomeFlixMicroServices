package com.codecool.videoservice;

import com.codecool.videoservice.entity.VideoEntity;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class VideoServiceApplication {

    @Autowired
    private VideoRepository videoRepository;


    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @PostConstruct
    private void initializeData(){


        VideoEntity video1 = VideoEntity.builder()
                .name("Friends")
                .url("https://www.youtube.com/watch?v=Yp0kth7-zsM")
                .build();

        VideoEntity video2 = VideoEntity.builder()
                .name("Rick and Morty")
                .url("https://www.youtube.com/watch?v=_VD217VhVJo&t=43s")
                .build();

        VideoEntity video3 = VideoEntity.builder()
                .name("Yellowstone")
                .url("https://www.youtube.com/watch?v=opYyuupyWmA").build();

        VideoEntity video4 = VideoEntity.builder()
                .name("The Durrels")
                .url("https://www.youtube.com/watch?v=wHFPoTkLpTM")
                .build();

        VideoEntity video5 = VideoEntity.builder()
                .name("Black Mirror")
                .url("https://www.youtube.com/watch?v=wHFPoTkLpTM")
                .build();

        videoRepository.saveAll(Arrays.asList(video1, video2, video3, video4, video5));
    }

}
