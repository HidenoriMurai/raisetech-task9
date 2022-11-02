package com.raisetech.raisetechtask.service;

import com.raisetech.raisetechtask.entity.User;
import com.raisetech.raisetechtask.form.CreateForm;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(int id);

    List<User> findByUser(Integer age);


    void createByUser(CreateForm form);

    void deleteByUser(int id);

    void updateByUser(User user);
}
