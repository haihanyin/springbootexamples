package com.github.hh.sbes.jdbc.isolation;

public class Film {

    private String name;
    private int point;

    public Film() {}

    public Film(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
