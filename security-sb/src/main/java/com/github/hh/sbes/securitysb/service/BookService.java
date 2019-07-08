package com.github.hh.sbes.securitysb.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

@Service
public class BookService {

    @Secured("USER")
    public void bookServiceForUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        System.out.println("bookServiceForUser");
    }

    @RolesAllowed("ADMIN")
    public void bookServiceForAdmin() {
        System.out.println("bookServiceForAdmin");
    }

}
