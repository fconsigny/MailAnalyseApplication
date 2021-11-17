package com.fconsigny.workshop.lecko.MailAnalyseApplication.controller;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.api.MicrosoftEmailServiceApi;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.EmailDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.EmailEntity;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.service.EmailService;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.requests.MessageCollectionPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users/{id}/emails")

@CrossOrigin
public class EmailController {


    private final EmailService emailService;

    public EmailController (EmailService emailService) {
        this.emailService = emailService;
    }


    @GetMapping
    @ResponseBody
    @CrossOrigin
    public List<EmailDto> findAllByUser(@PathVariable String id) {
        return emailService.findAll(id);
    }

    @PatchMapping("/{emailId}")
    @ResponseBody
    @CrossOrigin
    public EmailDto updateMail(@PathVariable String id, @PathVariable String emailId, @RequestBody EmailDto dto ) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("updateMail " + dto.isRead());
        logger.info("updateMail " + dto.getFromEmailAddress());
        Optional<EmailDto> savedEmail = emailService.updateEmail(emailId,dto);
        return savedEmail.get();
    }
}
