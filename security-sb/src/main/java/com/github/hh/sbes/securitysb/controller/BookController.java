package com.github.hh.sbes.securitysb.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class BookController {

    @GetMapping("/publicbook")
    public String publicBook() {
        return "This book is for public.";
    }

    @GetMapping("/userbook")
    public String userBook() {
        return "This book is for users.";
    }

    @GetMapping("/userbook2")
    public String userBook2(Principal principal) {
        return "Hello, userbook2, " + principal.getName();
    }

    @GetMapping("/userbook3")
    public String userBook3(Authentication authentication) {
        return "Hello, userbook3, " + authentication.getPrincipal().toString();
    }

    @GetMapping("/adminbook")
    public String adminBook() {
        return "This book is for admins";
    }
}
