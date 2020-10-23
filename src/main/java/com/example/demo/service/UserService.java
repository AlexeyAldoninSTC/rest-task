package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;

@Service
public class UserService {

    private final DataSource dataSource;
    private final UserRepository userRepository;

    public UserService(DataSource dataSource, UserRepository userRepository) {
        this.dataSource = dataSource;
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

}
