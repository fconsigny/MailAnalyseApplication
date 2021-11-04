package com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "email")
public class EmailEntity {
    @Id
    private String id;

    @Indexed(unique = true)
    @Field(value = "internet_message_id")
    private String internetMessageId;

    @Field(value = "created_date_time")
    private LocalDateTime createdDateTime;

    @Field(value = "last_modified_date_time")
    private LocalDateTime lastModifiedDateTime;

    @Field(value = "received_date_time")
    private LocalDateTime receivedDateTime;

    @Field(value = "send_date_time")
    private LocalDateTime sendDateTime;

    @Field(value = "has_attachments")
    private boolean hasAttachments;

    @Field(value = "subject")
    private String subject;

    @Field(value = "body_preview")
    private String bodyPreview;

    @Field(value = "is_read")
    private boolean isRead;

    @Field(value = "web_link")
    private String webLink;

    @Field(value = "send_email_address")
    private String senderEmailAddress;

    @Field(value = "send_email_address")
    private String fromEmailAddress;


}
