package com.example.carprice.DAO;

import com.example.carprice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository <Car, Long>{
    Car findCarByNumber(String number);

    @Query(value = "select * from cars  where is_buy=0 and is_deleted is null ",nativeQuery=true)
    List <Car> getNotBuyCars();
}
