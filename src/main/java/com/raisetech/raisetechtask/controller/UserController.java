package com.raisetech.raisetechtask.controller;

import com.raisetech.raisetechtask.entity.User;
import com.raisetech.raisetechtask.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    //ユーザー情報サービス
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //ユーザー情報一覧
    @GetMapping("/{id}")
    public Optional<User> getUserOne(@PathVariable("id") int id) {

        return userService.findById(id);
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers(@RequestParam(name = "age", required = false) Integer age) {

        return userService.findByUser(age).stream().map(UserResponse::new).toList();
    }
}
