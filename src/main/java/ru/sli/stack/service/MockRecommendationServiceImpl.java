package ru.sli.stack.service;

import java.util.ArrayList;
import java.util.List;


public class MockRecommendationServiceImpl implements RecommendationService {

    @Override
    public List<String> recommend() {
        List<String> strings = new ArrayList<>();
        strings.add("mockString1");
        strings.add("mockString2");
        strings.add("mockString3");
        return strings;
    }
}


