package com.example.carprice.service;

import com.example.carprice.entity.Car;
import com.example.carprice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyCarServiceImpl implements BuyCarService {
    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;

    @Override
    public boolean buy(Long userId, Long carId) {
        User user = userService.getById(userId);
        if (user == null) {//проверяем пользователя
            return false;
        }
        Car car = carService.getById(carId);
        if (car == null) { //проверяем наличие автомобиля
            return false;
        }
        // проверяем наличие автомобиля в списке доступных машин. Также можно использовать проверку с помощью цикла.
        List<Car> enableCars = carService.getAllNotBuy();
        Car actualCar = enableCars.stream().filter(c -> c.getId().equals(car.getId())).findFirst().orElse(null);
        if (actualCar==null){
            return false;}
       // Далее делаем проверку на плятежеспособность покупателя.
        if (car.getPrice()>user.getMoneyAmount()){
            return false;
        }

     car.setBuy(true);
        carService.saveCar(car);
        user.setCrNumber(car.getNumber());
        userService.saveUser(user);
        return true;
    }
}
