package com.fconsigny.workshop.lecko.MailAnalyseApplication.service;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.EmailDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.mapper.EmailMapper;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.EmailEntity;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.repository.EmailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    private EmailRepository emailRepository;

    private EmailMapper emailMapper;

    public EmailService(EmailRepository emailRepository, EmailMapper emailMapper) {

        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
    }

    public List<EmailDto> findAll(String userId) {
        return emailMapper.mapEntityToDtoList(emailRepository.findAllByUserId(userId));
    }

    public Optional<EmailDto> updateEmail(String emailId, EmailDto emailDto) {

        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("SHOULD UPDATE EMAIL " + emailDto.isRead());
        if (emailRepository.existsById(emailId)) {
            logger.info("EMAIL EXIST");
            emailDto.setId(emailId);
            EmailEntity savedEmail = emailRepository.save(emailMapper.mapDtoToEntity(emailDto));
            logger.info("EMAIL EXIST " + savedEmail.toString());
            logger.info("EMAIL EXIST " + savedEmail.getId());
            logger.info("EMAIL EXIST " + savedEmail.isRead());
            return Optional.of(emailMapper.mapEntityToDto(savedEmail));
        }

        return Optional.empty();
    }

}
