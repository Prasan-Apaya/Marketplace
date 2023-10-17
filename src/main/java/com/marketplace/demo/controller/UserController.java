package com.marketplace.demo.controller;


import com.marketplace.demo.models.User;
import com.marketplace.demo.service.UserService;
import com.marketplace.demo.utils.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User registerUser(@RequestBody User user) throws EmailExistsException {
        return userService.insertUser(user);
    }
    @GetMapping("/{userName}/{password}")
    public ResponseEntity<String> fetch(@PathVariable("userName") String userName, @PathVariable("password") String password) {
        if (userService.fetch(userName, password)) {
            return ResponseEntity.ok("Sign in successful");
        }
        return new ResponseEntity("Sign in unsuccessful", HttpStatus.BAD_REQUEST);
    }
}
