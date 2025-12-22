package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());  // ✅ fixed
        return "index";
    }

    @PostMapping("/addUser")
    public String addUser(User user) {
        userRepository.save(user);  // ✅ fixed
        return "redirect:/";
    }
}
