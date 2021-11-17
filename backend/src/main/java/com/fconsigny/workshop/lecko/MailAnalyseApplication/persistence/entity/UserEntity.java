package com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "user")
public class UserEntity {
    @Id
    private String id;

    @Indexed(unique = true)
    @Field(value = "mail")
    private String mail;

    @Field(value = "display_name")
    private String displayName;

    @Field(value = "given_name")
    private String givenName;

    @Field(value = "job_title")
    private String jobTitle;

    @Field(value = "mobile_phone")
    private String mobilePhone;

    @Field(value = "office_location")
    private String officeLocation;

    @Field(value = "preferred_language")
    private String preferredLanguage;

    @Field(value = "surname")
    private String surname;

    @Field(value = "user_principal_Name")
    private String userPrincipalName;

    @Field(value = "profile_picture")
    private String profilePicture;

}
