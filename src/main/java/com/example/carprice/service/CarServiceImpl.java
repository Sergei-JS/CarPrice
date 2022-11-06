package com.example.carprice.service;

import com.example.carprice.DAO.CarRepository;
import com.example.carprice.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    @Transactional
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    @Transactional
    public Car getById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            return;
        }
        Car car = carOptional.get();
        car.setIsDeleted(new Date());
        carRepository.save(car);
    }

    @Override
    @Transactional
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    @Transactional
    public List<Car> getAllNotBuy() {
        return carRepository.getNotBuyCars();
    }

    @Override
    @Transactional
    public Car getCarBuyNumber(String number) {
        return carRepository.findCarByNumber(number);
    }
}
