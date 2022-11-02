package com.raisetech.raisetechtask.controller;

import com.raisetech.raisetechtask.entity.User;
import com.raisetech.raisetechtask.form.CreateForm;
import com.raisetech.raisetechtask.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    //ユーザー情報サービス
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //ユーザー情報一覧
    @GetMapping("/users/{id}")
    public Optional<User> getUserOne(@PathVariable("id") int id) {

        return userService.findById(id);
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers(@RequestParam(name = "age", required = false) Integer age) {

        return userService.findByUser(age).stream().map(UserResponse::new).toList();
    }

    @PostMapping("/users/")
    public Map<String, String> createUser(@Validated @RequestBody CreateForm form) {
        userService.createByUser(form);
        return Map.of("message", "user successfully created");
    }

    @DeleteMapping("/users/{id}")
    public Map<String, String> deleteUser(@Validated @PathVariable("id") int id) {
        userService.deleteByUser(id);
        return Map.of("message", "user successfully deleted");
    }

    @PatchMapping("/users/{id}")
    public Map<String, String> updateUser(@Validated @PathVariable("id") int id, @RequestBody User user) {
        userService.updateByUser(user);
        return Map.of("message", "user successfully updated");
    }
}
