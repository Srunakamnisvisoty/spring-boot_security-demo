package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService {

    User findOne(Long id);

    List<User> findAll();

    User save(User user);

    void remove(Long id);

    User findUserByLogin(String login);
}
