package com.fconsigny.workshop.lecko.MailAnalyseApplication.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class EmailDto implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("internetMessageId")
    private String internetMessageId;

    @JsonProperty("createdDateTime")
    private LocalDateTime createdDateTime;

    @JsonProperty("lastModifiedDateTime")
    private LocalDateTime lastModifiedDateTime;

    @JsonProperty("receivedDateTime")
    private LocalDateTime receivedDateTime;

    @JsonProperty("sendDateTime")
    private LocalDateTime sendDateTime;

    @JsonProperty("hasAttachments")
    private boolean hasAttachments;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("bodyPreview")
    private String bodyPreview;

    @JsonProperty("isRead")
    private boolean isRead;

    @JsonProperty("webLink")
    private String webLink;

    @JsonProperty("senderEmailAddress")
    private String senderEmailAddress;

    @JsonProperty("fromEmailAddress")
    private String fromEmailAddress;

    @JsonProperty("body")
    private String body;

    @JsonProperty("toRecipients")
    private String toRecipients;

    @JsonProperty("importance")
    private String importance;

}
