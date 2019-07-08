package com.github.hh.sbes.exceptionhandling.controlleradvice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TextController {

    @GetMapping(value = "/showText")
    public void show() {
        throw new RuntimeException("show text exception");
    }

//    @ExceptionHandler(RuntimeException.class)
//    public Object handleException() {
//        System.out.println("ExceptionHandler handles an exception.");
//        return null;
//    }
}
