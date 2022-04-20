package ru.sli.stack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sli.stack.service.RecommendationService;

import java.util.List;

@RestController
public class RecommendationController {
    public RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/recommendations")
    public List<String> findAll() {
        return recommendationService.recommend();

    }
}
