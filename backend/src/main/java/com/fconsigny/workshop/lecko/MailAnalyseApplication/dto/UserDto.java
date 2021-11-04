package com.fconsigny.workshop.lecko.MailAnalyseApplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("givenName")
    private String givenName;

    @JsonProperty("jobTitle")
    private String jobTitle;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("mobilePhone")
    private String mobilePhone;

    @JsonProperty("officeLocation")
    private String officeLocation;

    @JsonProperty("preferredLanguage")
    private String preferredLanguage;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("userPrincipalName")
    private String userPrincipalName;

}
