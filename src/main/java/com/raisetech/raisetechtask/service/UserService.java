package com.raisetech.raisetechtask.service;

import com.raisetech.raisetechtask.entity.User;

import java.util.List;

public interface UserService {

    List<User> findById(int id);

    List<User> findAll();

    List<User> findByAge(int age);
}
