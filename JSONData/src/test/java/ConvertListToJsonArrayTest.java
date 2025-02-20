package com.practiceproblems.json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practiceproblems.json.listobjectstojsonarray.Car;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ConvertListToJsonArrayTest {

    @Test
    void testListToJsonConversion() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Car> cars = Arrays.asList(
                new Car("BMW", "M5", 2024),
                new Car("Audi", "A6", 2023),
                new Car("Tesla", "Model S", 2022)
        );

        objectMapper.writeValue(new File("src/main/resources/test_cars.json"), cars);

        Car[] readCars = objectMapper.readValue(new File("src/main/resources/test_cars.json"), Car[].class);

        assertEquals(3, readCars.length);
        assertEquals("BMW", readCars[0].getBrand());
        assertEquals("Audi", readCars[1].getBrand());
        assertEquals("Tesla", readCars[2].getBrand());
    }
}