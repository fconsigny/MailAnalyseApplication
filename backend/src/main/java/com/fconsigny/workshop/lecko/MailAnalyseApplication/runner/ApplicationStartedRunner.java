package com.fconsigny.workshop.lecko.MailAnalyseApplication.runner;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.api.MicrosoftEmailServiceApi;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.api.MicrosoftUserServiceApi;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.mapper.EmailMapper;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.mapper.UserMapper;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.EmailEntity;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.UserEntity;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.repository.EmailRepository;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.repository.UserRepository;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.requests.MessageCollectionPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationStartedRunner implements ApplicationRunner {

    private final MicrosoftUserServiceApi microsoftUserServiceApi;

    private final MicrosoftEmailServiceApi microsoftEmailServiceApi;

    private final UserRepository userRepository;

    private final EmailRepository emailRepository;

    private final EmailMapper emailMapper;

    private final UserMapper userMapper;

    public ApplicationStartedRunner(MicrosoftEmailServiceApi microsoftEmailServiceApi,MicrosoftUserServiceApi microsoftUserServiceApi, EmailMapper emailMapper, UserMapper userMapper, EmailRepository emailRepository, UserRepository userRepository) {
        this.microsoftEmailServiceApi = microsoftEmailServiceApi;
        this.microsoftUserServiceApi = microsoftUserServiceApi;
        this.emailMapper = emailMapper;
        this.userMapper = userMapper;
        this.emailRepository = emailRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<UserEntity> users = userMapper.mapGraphCollectionToEntityList(microsoftUserServiceApi.findUsers());
        Logger logger = LoggerFactory.getLogger(ApplicationStartedRunner.class);
        MessageCollectionPage messageCollectionPage;
        int i = 0;
        for (UserEntity user : users) {
            String imageUrl = microsoftUserServiceApi.findUserProfile(user.getId());
            if (imageUrl != null) {
                String d = imageUrl.replaceAll(".jpg", "");
                user.setProfilePicture("http://localhost:8080/mail-analyse/users/" + d + "/pictures");
            }

            try  {
                messageCollectionPage= microsoftEmailServiceApi.findEmailsByUserId(user.getId());
                 List<EmailEntity> entities = emailMapper.mapGraphCollectionToEntityList(messageCollectionPage,user.getId());
                 this.saveEmail(entities);
            }catch (Exception e ) {
                logger.info( "COUNT " + i++);
            }
        }

        userRepository.saveAll(users);
    }

    private void saveEmail(List<EmailEntity> entities) {
        emailRepository.saveAll(entities);

    }
}
