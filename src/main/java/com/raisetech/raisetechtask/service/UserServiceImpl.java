package com.raisetech.raisetechtask.service;

import com.raisetech.raisetechtask.entity.User;
import com.raisetech.raisetechtask.exception.ResourceNotFoundException;
import com.raisetech.raisetechtask.form.CreateForm;
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

    //IDが存在するかしないか。
    @Override
    public Optional<User> findById(int id) {
        Optional<User> user = this.userMapper.findById(id);
        if (user.isPresent()) {
            return userMapper.findById(id);
        } else {
            throw new ResourceNotFoundException("resource not found");
        }
    }

    //Param:ageの有無で全件取得or年齢指定検索→→→存在しない年齢が指定された場合ResourceNotFoundException
    @Override
    public List<User> findByAge(Integer age) {
        List<User> user = this.userMapper.findByAge(age);
        if (age == null) {
            return userMapper.findAll();
        } else if (user.isEmpty()) {
            throw new ResourceNotFoundException("resource not found");
        } else {
            return userMapper.findByAge(age);
        }
    }

    @Override
    public void createByUser(CreateForm form) {
        userMapper.createUser(form);
    }

    @Override
    public void deleteByUser(int id) {
        userMapper.deleteUserId(id);
    }

    @Override
    public void updateByUser(User user) {
        userMapper.updateUser(user);
    }
}
