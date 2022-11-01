package com.raisetech.raisetechtask.controller;

import com.raisetech.raisetechtask.entity.User;
import com.raisetech.raisetechtask.exception.ResourceNotFoundException;
import com.raisetech.raisetechtask.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
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

    //リソースなし例外処理
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
            ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
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

    @PostMapping("/users/create")
    public Map<String, String> createUser(@RequestBody User user) {
        userService.createByUser(user);
        return Map.of("message", "user successfully created");
    }

    @DeleteMapping("/users/delete/{id}")
    public Map<String, String> deleteUser(@PathVariable("id") int id) {
        userService.deleteByUser(id);
        return Map.of("message", "user successfully deleted");
    }

    @PatchMapping("/users/update/{id}")
    public Map<String, String> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        userService.updateByUser(user);
        return Map.of("message", "user successfully updated");
    }
}
