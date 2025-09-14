package com.example.crud.controller;

import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/")
    public String index(Model model) {
        System.out.println("Loading users...");
        var users = userRepository.findAll();
        System.out.println("Found " + users.size() + " users");
        users.forEach(user -> System.out.println("User: " + user));
        model.addAttribute("users", users);
        return "index";
    }
    
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }
    
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable String id, Model model) {
        model.addAttribute("user", userRepository.findById(id).orElse(new User()));
        return "form";
    }
    
    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable String id, Model model) {
        model.addAttribute("user", userRepository.findById(id).orElse(new User()));
        return "view";
    }
    
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        System.out.println("Saving user: " + user.getName() + " - " + user.getEmail());
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(null); // Force MongoDB to generate new ID
        }
        User saved = userRepository.save(user);
        System.out.println("User saved: " + saved);
        return "redirect:/";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }
}
