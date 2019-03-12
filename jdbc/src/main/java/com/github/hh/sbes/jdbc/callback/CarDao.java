package com.github.hh.sbes.jdbc.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addCar(int id, String name) {
        String sql = String.format(
                "insert into car(id, type) values(%d, '%s')", id, name);
        jdbcTemplate.update(sql);
    }

    public List<Car> findAllCarsWithHandler() {
        CarRowHandler carRowHandler = new CarRowHandler();
        jdbcTemplate.query("select * from car", carRowHandler);
        return carRowHandler.getCars();
    }

}
