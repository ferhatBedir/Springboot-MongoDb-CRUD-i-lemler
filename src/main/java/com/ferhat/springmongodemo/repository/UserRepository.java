package com.ferhat.springmongodemo.repository;

import com.ferhat.springmongodemo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Long> {

    User findOneByUserId(Long userId);

    List<User> findOneByUserFirstNameIgnoreCase(String userFirstName);
}
