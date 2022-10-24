package com.raisetech.raisetechtask.service;

import com.raisetech.raisetechtask.entity.User;
import com.raisetech.raisetechtask.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findByAge(int age) {
        return userMapper.findByAge(age);
    }
}