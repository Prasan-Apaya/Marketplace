package com.marketplace.demo.repository;

import com.marketplace.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT u FROM User u")
//    List<User> getEmailIds();
}
