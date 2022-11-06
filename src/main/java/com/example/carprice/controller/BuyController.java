package com.example.carprice.controller;

import com.example.carprice.service.BuyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buy")
public class BuyController {
    @Autowired
    private BuyCarService buyCarService;

    @GetMapping("/{userId}/{carId}")
    public Boolean buyCar(@PathVariable("userId") Long userId, @PathVariable("carId") Long carId){
        return buyCarService.buy(userId, carId);
    }
}
