package com.github.hh.sbes.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.Collections;
import java.util.Map;

@RestController
public class CarController {

    @RequestMapping(value = "/mycar", method = RequestMethod.GET)
    @ResponseBody
    public String mycar() {
        return "Lexus";
    }

}
