package com.github.hh.sbes.exceptionhandling.controlleradvice;

//@ControllerAdvice
public class ExceptionAdvice {

//    @ExceptionHandler(RuntimeException.class)
    public Object handleException() {
        System.out.println("Controller advice handles an exception.");
        return null;
    }
}
