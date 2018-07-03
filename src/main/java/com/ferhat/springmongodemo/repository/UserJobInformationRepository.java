package com.ferhat.springmongodemo.repository;

import com.ferhat.springmongodemo.entity.UserJobInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserJobInformationRepository extends MongoRepository<UserJobInformation, String> {
    UserJobInformation findByUserJobInformationId(String userJobInfoId);

    List<UserJobInformation> findOneByUserDepartmentNameIgnoreCase(String departmentName);

    UserJobInformation findByUserId(String userId);
}
