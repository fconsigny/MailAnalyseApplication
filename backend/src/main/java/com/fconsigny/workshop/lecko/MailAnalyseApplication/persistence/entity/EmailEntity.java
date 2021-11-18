package com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document(collection = "email")
public class EmailEntity {
    @Id
    private String id;

    @Field (value = "user_id")
    private String userId;

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

    @Field(value = "sender")
    private EmailTemplateEntity sender;

    @Field(value = "from")
    private EmailTemplateEntity from;

    @Field("body")
    private String body;

    @Field("toRecipients")
    private List<EmailTemplateEntity> toRecipients;

    @Field("importance")
    private String importance;

    @Override
    public String toString() {
        return "EmailEntity{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", internetMessageId='" + internetMessageId + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", lastModifiedDateTime=" + lastModifiedDateTime +
                ", receivedDateTime=" + receivedDateTime +
                ", sendDateTime=" + sendDateTime +
                ", hasAttachments=" + hasAttachments +
                ", subject='" + subject + '\'' +
                ", bodyPreview='" + bodyPreview + '\'' +
                ", isRead=" + isRead +
                ", webLink='" + webLink + '\'' +
                ", sender=" + sender +
                ", from=" + from +
                ", body='" + body + '\'' +
                ", toRecipients=" + toRecipients +
                ", importance='" + importance + '\'' +
                '}';
    }
}
