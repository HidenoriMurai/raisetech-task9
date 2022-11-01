package com.raisetech.raisetechtask.entity;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
public class User {
    @NotBlank
    @Positive
    private final int id;

    @NotBlank
    private String name;
    @Range(min = 1, max = 130)
    @NotBlank
    private Integer age;

    public User(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
