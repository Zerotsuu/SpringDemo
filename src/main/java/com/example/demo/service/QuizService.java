package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;

@Service
public class QuizService {
    private final Map<String, Integer> userGrades = new HashMap<>();

    public List<String[]> getShuffledQuestions() {
        String[][] questions = {
                {"What is 2 + 2?", "false:3", "true:4", "false:5", "false:6"},
                {"What is the name of the toy cowboy in Toy Story?", "false:Tree", "true:Woody", "false:Buzz", "false:Mike"},
                {"What is the color of an Emerald?", "false:Red", "true:Green", "false:Blue", "false:Rainbow"},
                {"Which Disney movie is Elsa in?", "false:Ninja Assassin", "true:Frozen", "false:Avengers", "false:Spiderman"},
                {"Who is Mickey Mouse's girlfriend?", "false:Betty White", "true:Minnie Mouse", "false:Amber Heard", "false:Goofy"},
        };
        List<String[]> questionList = Arrays.asList(questions);
        Collections.shuffle(questionList);
        return questionList;
    }

    public int calculateScore(Map<String, String> allParams) {
        int grade = 0;
        for (String key : allParams.keySet()) {
            if (allParams.get(key).startsWith("true")) {
                grade++;
            }
        }
        return grade;
    }

    public void saveUserGrade(String username, int grade) {
        userGrades.put(username, grade);
    }

    public Integer getUserGrade(String username) {
        return userGrades.get(username);
    }

    public Map<String, Integer> getAllUserGrades() {
        return userGrades;
    }
}
