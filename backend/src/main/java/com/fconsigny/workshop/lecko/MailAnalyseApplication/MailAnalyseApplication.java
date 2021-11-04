package com.fconsigny.workshop.lecko.MailAnalyseApplication;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.runner.ApplicationStartedRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailAnalyseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailAnalyseApplication.class, args);
    }

}
