package com.marketplace.demo.controller;


import com.marketplace.demo.dto.UserDto;
import com.marketplace.demo.service.UserService;
import com.marketplace.demo.utils.exception.EmailExistsException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/user")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @PostMapping
    ResponseEntity<String> registerUser(@RequestBody @Valid UserDto user) throws EmailExistsException {
        LOGGER.debug("Registering user account with information: {}", user);

        userService.insertUser(user);
        return ResponseEntity.ok("User is valid");
    }

    @GetMapping("/{userName}/{password}")
    public ResponseEntity<String> fetch(@PathVariable("userName") String userName, @PathVariable("password") String password) {
        if (userService.fetch(userName, password)) {
            return new ResponseEntity<>("Sign in successful",HttpStatus.OK);
        }
        return new ResponseEntity<>("Sign in unsuccessful", HttpStatus.BAD_REQUEST);
    }
}
