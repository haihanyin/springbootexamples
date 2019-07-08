package com.github.hh.sbes.exceptionhandling.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class PageController {

    @RequestMapping(value = "/showPage", method = GET)
    public String showBookWithModel(Model dataModel) {
        throw new RuntimeException("myRuntimeException");
    }

    @ExceptionHandler(RuntimeException.class)
    public void handleException() {
        System.out.println("ExceptionHandler handles an exception.");
    }
}
