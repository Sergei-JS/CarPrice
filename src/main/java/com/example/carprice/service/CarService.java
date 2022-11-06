package com.example.carprice.service;

import com.example.carprice.entity.Car;
import com.example.carprice.entity.User;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    Car getById(Long id);

    void deleteById(Long id);

    void saveCar(Car car);

    List<Car> getAllNotBuy();

    Car getCarBuyNumber(String number);

}
