package com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.repository;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

}
