package practiseproblems.listobjectsjsonarray;

package com.practiceproblems.json.listobjectstojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.io.*;

public class ConvertListToJsonArray {
    public static void main(String[] args) {
        try {
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("BMW", "M5", 2024));
            cars.add(new Car("Audi", "A6", 2023));
            cars.add(new Car("Tesla", "Model S", 2022));

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(cars);

            objectMapper.writeValue(new File("src/main/resources/objectList.json"), cars);

            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}