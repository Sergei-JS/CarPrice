package com.example.carprice.DAO;

import com.example.carprice.entity.User;
import com.example.carprice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional
    public User getById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Optional<User> userOptional = usersRepository.findById(id);
        if (userOptional.isEmpty()) {
            return;
        }
        User user = userOptional.get();
        user.setIsDeleted(new Date());
        usersRepository.save(user);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
    usersRepository.save(user);
    }
}

