package com.raisetech.raisetechtask.controller;

import com.raisetech.raisetechtask.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private int id;

    private String name;

    private int age;

    //UserからUserResponseに変換するためのコンストラクタ
    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }
}
