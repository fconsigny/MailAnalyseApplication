package com.fconsigny.workshop.lecko.MailAnalyseApplication.controller;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.api.MicrosoftEmailServiceApi;
import com.microsoft.graph.requests.MessageCollectionPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users/{id}/emails")
public class EmailController {


    private final MicrosoftEmailServiceApi microsoftEmailServiceApi;

    public EmailController (MicrosoftEmailServiceApi microsoftEmailServiceApi) {
        this.microsoftEmailServiceApi = microsoftEmailServiceApi;
    }


    @GetMapping
    @ResponseBody
    public MessageCollectionPage findAllByUser(@PathVariable String id) {
        return microsoftEmailServiceApi.findEmailsByUserId(id);
    }
}
