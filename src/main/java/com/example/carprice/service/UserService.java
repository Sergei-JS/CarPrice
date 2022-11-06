package com.example.carprice.service;

import com.example.carprice.entity.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById (Long id);

    void deleteById(Long id);

    void saveUser (User user);

}
