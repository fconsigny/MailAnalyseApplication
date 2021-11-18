package com.fconsigny.workshop.lecko.MailAnalyseApplication.controller;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.EmailDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        Optional<EmailDto> savedEmail = emailService.updateEmail(emailId,dto);
        return savedEmail.get();
    }

    @GetMapping("/{emailValue}")
    @ResponseBody
    @CrossOrigin
    public List<EmailDto> findEmailsSendedByTheUser(@PathVariable String id,@PathVariable String emailValue) {
        return emailService.findEmailsSendedByTheUser(id,emailValue);
    }
}
