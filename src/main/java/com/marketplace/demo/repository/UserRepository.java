package com.marketplace.demo.repository;

import com.marketplace.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT emailId FROM users u")
    List<String> getEmailIds();

    @Query("SELECT u FROM users u WHERE u.userName = :userName and u.password= :password ")
    User fetch(@Param("userName") String userName, @Param("password") String password);
}
