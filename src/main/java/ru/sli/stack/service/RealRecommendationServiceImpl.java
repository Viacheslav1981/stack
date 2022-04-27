package ru.sli.stack.service;

import java.util.ArrayList;
import java.util.List;

public class RealRecommendationServiceImpl implements RecommendationService {

    @Override
    public List<String> recommend() {
        List<String> strings = new ArrayList<>();
        strings.add("realString1");
        strings.add("realString2");
        strings.add("realString3");
        return strings;
    }
}
