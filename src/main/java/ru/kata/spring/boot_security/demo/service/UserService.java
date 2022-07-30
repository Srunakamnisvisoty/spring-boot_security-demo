package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findOne(Long id);

    List<User> findAll();

    User save(User user);

    void remove(Long id);

    User findUserByLogin(String login);
}
