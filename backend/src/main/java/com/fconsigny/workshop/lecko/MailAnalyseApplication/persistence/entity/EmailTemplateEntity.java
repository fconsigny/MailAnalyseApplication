package com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "email_template")
public class EmailTemplateEntity {

    @Id
    private String emailAddress;

    @Indexed(unique = true)
    @Field(value = "mail")
    private String name;

}
