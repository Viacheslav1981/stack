package ru.sli.stack.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecommendationService {
    public List<String> recommend() {
        List<String> strings = new ArrayList<>();
        strings.add("testString1");
        strings.add("testString2");
        strings.add("testString3");
        return strings;
    }
}
