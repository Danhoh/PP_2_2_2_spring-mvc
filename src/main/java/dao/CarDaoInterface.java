package dao;

import entity.Car;

import java.util.List;

public interface CarDaoInterface {
    List<Car> getNCars(Integer count);
}
