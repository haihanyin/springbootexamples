package com.github.hh.sbes.jdbc.callback;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRowHandler implements RowCallbackHandler {
    private List<Car> cars = new ArrayList<>();

    @Override
    public void processRow(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        int id = resultSet.getInt("id");
        car.setId(99);
        String type = resultSet.getString("type");
        car.setType(type);
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
