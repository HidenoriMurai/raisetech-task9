package com.raisetech.raisetechtask.controller;

import com.raisetech.raisetechtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    //ユーザー情報サービス
    @Autowired
    private UserService userService;

    //ユーザー情報一覧
    @GetMapping("/users")
    public List<UserResponse> getAll() {

        return userService.findAll().stream().map(UserResponse::new).toList();
    }

    @GetMapping("/users/{id}")
    public List<UserResponse> getUserOne(@PathVariable("id") int id) {

        return userService.findById(id).stream().map(UserResponse::new).toList();
    }


    @GetMapping("/users/{age}")
    public List<UserResponse> getUsers(@RequestParam("age") int age) {

        return userService.findByAge(age).stream().map(UserResponse::new).toList();
    }
}
