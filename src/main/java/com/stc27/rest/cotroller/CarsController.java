package com.stc27.rest.cotroller;

import com.stc27.rest.entity.Car;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/coolrest")
public class CarsController {



    private final DataSource dataSource;


    public CarsController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/cars")
    public List<Car> getCars() {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        List<Car> result = jdbcTemplate.query("SELECT * FROM cars", new RowMapper<Car>() {
                    @Override
                    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
                        Car car = new Car();
                        car.setId(resultSet.getInt(1));
                        car.setModel(resultSet.getString(2));
                        car.setColor(resultSet.getString(3));
                        car.setHorsePower(resultSet.getLong(4));
                        return car;
                    }
                });

        return result;
    }

    @GetMapping("/cars/{id}")
    public Object getCarByIdJdbc(@PathVariable("id") Integer id) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Map<String, Integer> paramMap = new HashMap<>();
        paramMap.put("id", id);
        Map<String, Object> result = jdbcTemplate.queryForMap("SELECT * FROM cars WHERE id=:id", paramMap);
        return result;
    }


}
