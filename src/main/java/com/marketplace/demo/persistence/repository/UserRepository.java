package com.marketplace.demo.persistence.repository;

import com.marketplace.demo.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {

    @Query("SELECT emailId FROM users u")
    List<String> getEmailIds();

    @Query("SELECT u FROM users u WHERE u.userName = :userName and u.password= :password ")
    UserDto fetch(@Param("userName") String userName, @Param("password") String password);
}
