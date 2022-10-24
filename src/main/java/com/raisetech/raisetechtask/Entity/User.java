package com.raisetech.raisetechtask.entity;

import lombok.Getter;

@Getter
public class User {
    private final int id;

    private String name;

    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
