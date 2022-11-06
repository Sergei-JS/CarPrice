package com.example.carprice.controller;

import com.example.carprice.entity.Car;
import com.example.carprice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/")
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Long id) {
        return carService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        carService.deleteById(id);
    }

    @PostMapping("/")
    public Car addcar(@RequestBody Car car) {
        carService.saveCar(car);
        return car;
    }

    @PutMapping("/")
    public Car updateUser(@RequestBody Car car) {
        carService.saveCar(car);
        return car;
    }

    @GetMapping("/allActual")
    public List<Car> getActial() {
        return carService.getAllNotBuy();
    }

    @GetMapping("/num/{number}")
    public Car getBuyNumber(@PathVariable String number) {
        return carService.getCarBuyNumber(number);
    }
}
