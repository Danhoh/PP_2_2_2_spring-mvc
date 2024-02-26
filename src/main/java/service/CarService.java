package service;

import Entity.Car;
import dao.CarDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarDao carDao = new CarDao();

    public List<Car> getNCars(Integer count) {
        return carDao.getNCars(count);
    }

    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }
}
