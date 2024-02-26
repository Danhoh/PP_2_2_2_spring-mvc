package web.controller;

import Entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(defaultValue = "6") int count) {
        List<Car> cars = count <= 5 ? carService.getNCars(count) : carService.getAllCars();

        model.addAttribute("cars", cars);
        return "cars";
    }
}