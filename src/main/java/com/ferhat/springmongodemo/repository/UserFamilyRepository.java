package com.ferhat.springmongodemo.repository;

import com.ferhat.springmongodemo.entity.UserFamilyInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserFamilyRepository extends MongoRepository<UserFamilyInfo, Long> {
    UserFamilyInfo findFirstByUserFamilyIdAndUserId(Long userfamilyId, Long userId);
}
