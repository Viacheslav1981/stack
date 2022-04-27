package ru.sli.stack.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecommendationConfig {

    @Bean
    @ConditionalOnProperty(value = "propertyRealRecommendationService", havingValue = "false")
    // @Qualifier("mock")
    public RecommendationService mockRecommendationService() {
        RecommendationService recommendationService = new MockRecommendationServiceImpl();
        return recommendationService;
    }

    @Bean
    //@Qualifier("real")
    @ConditionalOnProperty(value = "propertyRealRecommendationService", havingValue = "true")
    public RecommendationService realRecommendationService() {
        RecommendationService recommendationService = new RealRecommendationServiceImpl();
        return recommendationService;
    }
}
