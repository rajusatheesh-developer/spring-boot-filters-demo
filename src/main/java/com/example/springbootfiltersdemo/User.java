package com.example.springbootfiltersdemo;

import lombok.Data;

@Data
public class User {

    protected String name;

    public User(String name) {
        this.name=name;
    }
}
