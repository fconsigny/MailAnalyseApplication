package com.fconsigny.workshop.lecko.MailAnalyseApplication.service;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.UserDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.mapper.UserMapper;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.UserEntity;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> findAll() {
        return userMapper.mapEntityToDtoList(userRepository.findAll());
    }

    public UserDto findOneById(String id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(userEntity -> userMapper.mapEntityToDto(userEntity)).orElse(null);
    }

    public void deleteById( String id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
