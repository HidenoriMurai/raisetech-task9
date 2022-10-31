package com.raisetech.raisetechtask.service;

import com.raisetech.raisetechtask.entity.User;
import com.raisetech.raisetechtask.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findByUser(Integer age) {
        if (age == null) {
            return userMapper.findAll();
        } else {
            return userMapper.findByAge(age);
        }
    }
}
