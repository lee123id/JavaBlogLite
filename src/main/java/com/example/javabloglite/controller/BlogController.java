package com.example.javabloglite.controller;

import com.example.javabloglite.model.Post;
import com.example.javabloglite.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "index";
    }

    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        model.addAttribute("post", postRepository.findById(id).orElse(null));
        return "post";
    }

    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "new";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/";
    }
}