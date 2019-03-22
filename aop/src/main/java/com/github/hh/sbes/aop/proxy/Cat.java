package com.github.hh.sbes.aop.proxy;

public class Cat implements Animal {

    public Cat() {
        System.out.println("A cat is created.");
    }

    @Override
    public void speak() {
        System.out.println("Miew");
    }
}
