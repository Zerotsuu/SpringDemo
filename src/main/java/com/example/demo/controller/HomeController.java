package com.example.demo.controller;

import com.example.demo.model.UserSession;
import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

//controllers donw :
// Login, Home, Quiz, Tally of Quiz
@Controller
public class HomeController {
    private final QuizService quizService;


    public int finalScore = 0;
    @Autowired
    private UserSession userSession;

    @Autowired
    public HomeController(QuizService quizService) {
        this.quizService = quizService;
    }

    //recursive function to login when user is not logged in
    @GetMapping("/")
    public String home(Model model) {
        if (userSession.getUsername() == null) return "redirect:/login";
        model.addAttribute("message", "Hello, Springs Boot with JSP!");
        model.addAttribute("userSession", userSession);
        return "home";
    }

    //shows login form if user is not logged in
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    //redirects user to "/" when user is not logged in
    @PostMapping("/login")
    public String login(String username, String password) {
        // Your authentication logic goes here (e.g., check username/password against database)
        System.out.println("username: " + username + ", password: " + password);
        if ("jun".equals(username) && "123".equals(password)) {
            userSession.setUsername(username);
            return "redirect:/";
        } else {
            return "redirect:/login?error=invalid username or password";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        userSession.setUsername(null);
        return "redirect:/login";
    }

    @GetMapping("/grade")
    public String gradePage(Model model) {
        String username = userSession.getUsername();
        if (username == null) return "redirect:/login";

        model.addAttribute("username", username);
        model.addAttribute("grade", quizService.getAllUserGrades().get(username));
        model.addAttribute("allGrades", quizService.getAllUserGrades());
        return "grade";
    }

    @GetMapping("/quiz")
    public String quizPage(Model model) {
        String username = userSession.getUsername();
        if (username == null) return "redirect:/login";
        List<String[]> questions = quizService.getShuffledQuestions();
        model.addAttribute("questions", questions);
        return "quiz";
    }

    @PostMapping("/quiz")
    public String submitQuiz(@RequestParam Map<String, String> allParams) {
        String username = userSession.getUsername();
        if (username == null) return "redirect:/login";

        int score = quizService.calculateScore(allParams);
        quizService.saveUserGrade(username, score);

        return "redirect:/grade";
    }
}
