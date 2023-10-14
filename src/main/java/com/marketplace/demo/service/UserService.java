package com.marketplace.demo.service;

import com.marketplace.demo.models.User;
import com.marketplace.demo.repository.UserRepository;
import com.marketplace.demo.utils.Utils;
import com.marketplace.demo.utils.exception.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User insertUser(User user) throws EmailExistsException {
        if (Utils.emailExists(user.getEmailId(), userRepository.getEmailIds())) {
            throw new EmailExistsException("Email already exits");
        } else {
            return userRepository.save(user);
        }
    }
}
