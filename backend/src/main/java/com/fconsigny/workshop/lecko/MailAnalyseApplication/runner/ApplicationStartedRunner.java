package com.fconsigny.workshop.lecko.MailAnalyseApplication.runner;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.api.MicrosoftUserServiceApi;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.mapper.UserMapper;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.UserEntity;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationStartedRunner implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;


    @Autowired
    MicrosoftUserServiceApi microsoftUserServiceApi;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserMapper userMapper = new UserMapper();
        List<UserEntity> users = userMapper.mapGraphCollectionToEntityList(microsoftUserServiceApi.findUsers());
        userRepository.saveAll(users);

        for (UserEntity user : users) {

        }
    }
}
