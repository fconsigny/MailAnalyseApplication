package com.fconsigny.workshop.lecko.MailAnalyseApplication.service;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.EmailDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.mapper.EmailMapper;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.EmailEntity;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.repository.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    private final EmailMapper emailMapper;

    public EmailService(EmailRepository emailRepository, EmailMapper emailMapper) {
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
    }

    public List<EmailDto> findAll(String userId) {
        List<EmailEntity> entities = emailRepository.findAllByUserId(userId);
        return emailMapper.mapEntityToDtoList(entities);
    }

    public Optional<EmailDto> updateEmail(String emailId, EmailDto emailDto) {

        if (emailRepository.existsById(emailId)) {
            emailDto.setId(emailId);
            EmailEntity savedEmail = emailRepository.save(emailMapper.mapDtoToEntity(emailDto));
            return Optional.of(emailMapper.fillDto(savedEmail));
        }

        return Optional.empty();
    }

    public List<EmailDto> findEmailsSendedByTheUser(String emailId, String emailValue) {
        return emailMapper.mapEntityToDtoList(emailRepository.findEmailEntitiesByFrom_EmailAddress(emailValue));
    }

}
