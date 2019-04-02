package com.github.hh.sbes.mvcxml.controller;

import com.github.hh.sbes.mvcxml.filter.AdminFilter;
import com.github.hh.sbes.mvcxml.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostConstruct
    public void init() {
        System.out.println("FilmController is created.");
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(Model model) {
        model.addAttribute("name", filmService.getFilmName());
        return "hello";
    }

    @RequestMapping(value = "/myforward", method = RequestMethod.GET)
    @ResponseBody
    public String myforward() {
        return "this request has been forwarded.";
    }
}
