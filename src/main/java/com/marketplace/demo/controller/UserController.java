package com.marketplace.demo.controller;


import com.marketplace.demo.models.User;
import com.marketplace.demo.service.UserService;
import com.marketplace.demo.utils.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User registerUser(@RequestBody User user) throws EmailExistsException {
        System.out.println("inside porint lin");
        return userService.insertUser(user);
    }
}
