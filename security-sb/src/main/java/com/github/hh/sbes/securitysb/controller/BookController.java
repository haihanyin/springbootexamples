package com.github.hh.sbes.securitysb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/adminbook")
    public String adminBook() {
        return "This book is for admins";
    }
}
