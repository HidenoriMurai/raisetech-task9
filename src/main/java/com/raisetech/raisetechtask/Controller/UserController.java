package com.raisetech.raisetechtask.controller;

import com.raisetech.raisetechtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    //ユーザー情報サービス
    @Autowired
    private UserService userService;

    //ユーザー情報一覧
    @GetMapping("/")
    public List<UserResponse> getAll() {

        return userService.findAll().stream().map(UserResponse::new).toList();
    }

    @GetMapping("/{id}")
    public List<UserResponse> getUserOne(@PathVariable("id") int id) {

        return userService.findById(id).stream().map(UserResponse::new).toList();
    }


    @GetMapping
    public List<UserResponse> getUsers(@RequestParam("age") int age) {

        return userService.findByAge(age).stream().map(UserResponse::new).toList();
    }
}
