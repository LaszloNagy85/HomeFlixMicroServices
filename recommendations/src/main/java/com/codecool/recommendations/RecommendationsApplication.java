package com.codecool.recommendations;

import com.codecool.recommendations.entity.RecommendationEntity;
import com.codecool.recommendations.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class RecommendationsApplication {

	@Autowired
	private RecommendationsRepository recommendationsRepository;

	public static void main(String[] args) {
		SpringApplication.run(RecommendationsApplication.class, args);
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
	private void initializeData() {
		RecommendationEntity rec1 = RecommendationEntity.builder()
				.rating(5)
				.comment("Best series ever!!!")
				.videoId(1)
				.build();

		RecommendationEntity rec2 = RecommendationEntity.builder()
				.rating(5)
				.comment("Best animated series ever!!!")
				.videoId(2)
				.build();

		RecommendationEntity rec3 = RecommendationEntity.builder()
				.rating(5)
				.comment("My all time favourite one!!!")
				.videoId(1)
				.build();

		RecommendationEntity rec4 = RecommendationEntity.builder()
				.rating(5)
				.comment("Best fun/retro series ever made! Love it!!")
				.videoId(4)
				.build();

		RecommendationEntity rec5 = RecommendationEntity.builder()
				.rating(4)
				.comment("Not bad, bit slow start.")
				.videoId(3)
				.build();

		recommendationsRepository.saveAll(Arrays.asList(rec1, rec2, rec3, rec4, rec5));
	}
}
