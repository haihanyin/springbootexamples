package com.github.hh.sbes.jdbc.callback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CarDaoTest.TestConfiguration.class)
public class CarDaoTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.jdbc.callback")
    static class TestConfiguration { }

    @Autowired
    private CarDao carDao;

    @Test
    public void testRowHandler() {
        carDao.addCar(1, "Audi");
        carDao.addCar(2, "Toyota");
        List<Car> allCarsWithHandler = carDao.findAllCarsWithHandler();
        allCarsWithHandler.forEach(System.out::println);
    }

    @Test
    public void testExtractor() {
        carDao.addCar(1, "Audi");
        carDao.addCar(2, "Toyota");
        List<Car> allCarsWithExtractor = carDao.findAllCarsWithExtractor();
        allCarsWithExtractor.forEach(System.out::println);
    }

}
