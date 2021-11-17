package com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.repository;


import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.EmailEntity;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends MongoRepository<EmailEntity, String> {

    List<EmailEntity> findAllByUserId(String userId);

}
