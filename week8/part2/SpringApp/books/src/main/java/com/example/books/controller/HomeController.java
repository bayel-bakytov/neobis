package com.example.books.controller;

import com.example.books.entity.Role;
import com.example.books.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("user", user.getFirstName());
            return "index";
        }
        model.addAttribute("user", "anonymous");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PreAuthorize(value = "hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/user")
    public String users() {
        return "user";
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String admins(@AuthenticationPrincipal User user,Model model) {
        if (!user.getRoles().equals(Role.USER)) {
            model.addAttribute("user", user.getFirstName());
            return "admin";
        }
        model.addAttribute("user", "Sorry you not admin");
        return "redirect:/";
    }

}
