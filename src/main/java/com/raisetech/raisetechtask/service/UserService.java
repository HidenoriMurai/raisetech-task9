package com.raisetech.raisetechtask.service;

import com.raisetech.raisetechtask.entity.User;
import com.raisetech.raisetechtask.form.CreateForm;

import java.util.List;

public interface UserService {

    User findById(int id);
    

    //Param:ageの有無で全件取得or年齢指定検索→→→存在しない年齢が指定された場合ResourceNotFoundException
    List<User> findByAge(Integer age);

    void createByUser(CreateForm form);

    void deleteByUser(int id);

    void updateByUser(User user);
}
