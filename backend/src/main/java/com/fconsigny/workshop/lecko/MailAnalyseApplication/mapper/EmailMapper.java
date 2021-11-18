package com.fconsigny.workshop.lecko.MailAnalyseApplication.mapper;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.EmailDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.EmailTemplateDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.EmailEntity;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.EmailTemplateEntity;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.models.Recipient;
import com.microsoft.graph.requests.MessageCollectionPage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmailMapper {

    public EmailEntity mapGraphCollectionToEntity(final Message message, final String userId) {

        EmailEntity entity = new EmailEntity();

        entity.setId(message.id);
        entity.setUserId(userId);
        entity.setInternetMessageId(message.internetMessageId);
        entity.setCreatedDateTime(message.createdDateTime.toLocalDateTime());
        entity.setLastModifiedDateTime(message.lastModifiedDateTime.toLocalDateTime());
        entity.setSendDateTime(message.sentDateTime.toLocalDateTime());
        entity.setReceivedDateTime(message.receivedDateTime.toLocalDateTime());
        entity.setBodyPreview(message.bodyPreview);
        entity.setFrom(new EmailTemplateEntity(message.from.emailAddress.address, message.from.emailAddress.name));
        entity.setSender(new EmailTemplateEntity(message.sender.emailAddress.address, message.from.emailAddress.name));
        entity.setSubject(message.subject);
        entity.setWebLink(message.webLink);
        entity.setHasAttachments(message.hasAttachments);
        entity.setRead(message.isRead);
        entity.setBody(message.body.content);
        entity.setImportance(message.importance.name());

        List<EmailTemplateEntity> emailAddresses = new ArrayList<>();
        for (Recipient recipient : message.toRecipients) {
            EmailTemplateEntity email = new EmailTemplateEntity(recipient.emailAddress.address, recipient.emailAddress.name);
            emailAddresses.add(email);
        }

        entity.setToRecipients(emailAddresses);
        return entity;
    }

    public List<EmailEntity> mapGraphCollectionToEntityList(final MessageCollectionPage collectionPage, final String userId) {
        List<Message> messages = collectionPage.getCurrentPage();
        List<EmailEntity> entityList = new ArrayList<>();
        for (Message message : messages) {
            entityList.add(mapGraphCollectionToEntity(message, userId));
        }
        return entityList;
    }

    public EmailDto fillDto(EmailEntity entity) {
        EmailDto dto = new EmailDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setInternetMessageId(entity.getInternetMessageId());
        dto.setCreatedDateTime(entity.getCreatedDateTime());
        dto.setLastModifiedDateTime(entity.getLastModifiedDateTime());
        dto.setSendDateTime(entity.getSendDateTime());
        dto.setReceivedDateTime(entity.getReceivedDateTime());
        dto.setBodyPreview(entity.getBodyPreview());

        dto.setSubject(entity.getSubject());
        dto.setWebLink(entity.getWebLink());
        dto.setHasAttachments(entity.isHasAttachments());
        dto.setRead(entity.isRead());
        dto.setBody(entity.getBody());
        dto.setImportance(entity.getImportance());

        if (entity.getFrom() != null)
            dto.setFrom(new EmailTemplateDto(entity.getFrom().getEmailAddress(), entity.getFrom().getName()));

        List<EmailTemplateEntity> recipients = entity.getToRecipients();
        List<EmailTemplateDto> templateDtos = new ArrayList<>();

        for (EmailTemplateEntity email : recipients) {

            if (email != null)
                templateDtos.add(new EmailTemplateDto(email.getEmailAddress(), email.getName()));
        }

        if (entity.getSender() != null)
            dto.setSender(new EmailTemplateDto(entity.getSender().getEmailAddress(), entity.getSender().getName()));

        dto.setToRecipients(templateDtos);

        return dto;
    }

    public List<EmailDto> mapEntityToDtoList(List<EmailEntity> emails) {
        return emails.stream()
                .map(this::fillDto)
                .collect(Collectors.toList());
    }
}
