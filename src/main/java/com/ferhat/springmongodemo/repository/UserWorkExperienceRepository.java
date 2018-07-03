package com.ferhat.springmongodemo.repository;

import com.ferhat.springmongodemo.entity.UserWorkExperience;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserWorkExperienceRepository extends MongoRepository<UserWorkExperience, String> {
    UserWorkExperience findByUserWorkExperienceId(String userWorkExperienceId);

    List<UserWorkExperience> findOneByCompanyName(String companyName);

    UserWorkExperience findByUserId(String userId);
}
