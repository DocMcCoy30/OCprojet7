package com.dmc30.userapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(path = "/check")
    public String status() {
        return "user-api's working!";
    }

    @PostMapping
    public String createUser() {
        return "creating a user";
    }

}
