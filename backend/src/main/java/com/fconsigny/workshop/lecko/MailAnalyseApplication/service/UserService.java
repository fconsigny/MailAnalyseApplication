package com.fconsigny.workshop.lecko.MailAnalyseApplication.service;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.UserEntity;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
}
