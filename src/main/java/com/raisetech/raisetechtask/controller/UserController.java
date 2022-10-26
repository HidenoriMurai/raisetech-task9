package com.raisetech.raisetechtask.controller;

import com.raisetech.raisetechtask.entity.User;
import com.raisetech.raisetechtask.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    //ユーザー情報サービス
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //ユーザー情報一覧
    @GetMapping()
    public List<UserResponse> getAll() {

        return userService.findAll().stream().map(UserResponse::new).toList();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserOne(@PathVariable("id") int id) {

        return userService.findById(id);
    }

    @GetMapping("/search")
    public List<UserResponse> getUsers(@RequestParam("age") int age) {

        return userService.findByAge(age).stream().map(UserResponse::new).toList();
    }
}
