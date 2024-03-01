package dao;

import entity.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDao implements CarDaoInterface {
// hibernate здесь, как я понял, не нужен, просто массива хватит
    private static final ArrayList<Car> storedCars = new ArrayList<>(List.of(new Car[]{
        new Car("BMW", "X5", 1234),
        new Car("BMW", "X6", 1488),
        new Car("BMW", "X7", 1337),
        new Car("Lada", "Calina", 228),
        new Car("Gaz", "21010", 2233),
    }));

    public List<Car> getNCars(Integer count) {
        return count >= 5 ? storedCars : storedCars.subList(0, count);
    }
}
