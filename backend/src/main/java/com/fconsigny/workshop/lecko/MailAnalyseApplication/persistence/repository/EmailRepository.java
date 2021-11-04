package com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.repository;


import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.EmailEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends MongoRepository<EmailEntity, String> {

}
