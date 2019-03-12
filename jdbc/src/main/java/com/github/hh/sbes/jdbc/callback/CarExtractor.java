package com.github.hh.sbes.jdbc.callback;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarExtractor implements ResultSetExtractor<List<Car>> {

    @Override
    public List<Car> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Car> carList = new ArrayList<>();
        while(resultSet.next()) {
            Car car = new Car();
            int id = resultSet.getInt("id");
            car.setId(id);
            String type = resultSet.getString("type");
            car.setType(type);
            carList.add(car);
        }
        return carList;
    }
}
