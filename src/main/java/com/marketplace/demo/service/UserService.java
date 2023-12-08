package com.marketplace.demo.service;

import com.marketplace.demo.dto.UserDto;
import com.marketplace.demo.persistence.repository.UserRepository;
import com.marketplace.demo.utils.Utils;
import com.marketplace.demo.utils.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDto insertUser(UserDto user) throws EmailExistsException {
        if (Utils.emailExists(user.getEmailId(), userRepository.getEmailIds())) {
            throw new EmailExistsException("Email already exits");
        } else {
            return userRepository.save(new UserDto(user.getUserName(),passwordEncoder.encode(user.getPassword()),user.getEmailId(),user.getPhoneNumber()));
        }
    }

    public boolean fetch(String userName, String password) {
        return userRepository.fetch(userName, password) != null;
    }
}
