package com.ferhat.springmongodemo.repository;

import com.ferhat.springmongodemo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

    User findOneByUserId(Long userId);
}
