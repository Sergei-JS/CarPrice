package com.example.carprice.DAO;

import com.example.carprice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository <User, Long> {
    
}
