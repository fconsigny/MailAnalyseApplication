package com.fconsigny.workshop.lecko.MailAnalyseApplication.mapper;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.EmailDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.EmailEntity;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.requests.MessageCollectionPage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        entity.setFromEmailAddress(message.from.emailAddress.address.toLowerCase(Locale.ROOT));
        entity.setSenderEmailAddress(message.sender.emailAddress.address.toLowerCase(Locale.ROOT));
        entity.setSubject(message.subject);
        entity.setWebLink(message.webLink);
        entity.setHasAttachments(message.hasAttachments);
        entity.setRead(message.isRead);
        entity.setBody(message.body.content);
        entity.setImportance(message.importance.name());
        entity.setToRecipients(message.toRecipients.get(0).emailAddress.address);
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

    public EmailDto mapEntityToDto(EmailEntity entity) {
        EmailDto dto = new EmailDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setInternetMessageId(entity.getInternetMessageId());
        dto.setCreatedDateTime(entity.getCreatedDateTime());
        dto.setLastModifiedDateTime(entity.getLastModifiedDateTime());
        dto.setSendDateTime(entity.getSendDateTime());
        dto.setReceivedDateTime(entity.getReceivedDateTime());
        dto.setBodyPreview(entity.getBodyPreview());
        dto.setFromEmailAddress(entity.getFromEmailAddress());
        dto.setToRecipients(entity.getToRecipients());
        dto.setSenderEmailAddress(entity.getSenderEmailAddress());
        dto.setSubject(entity.getSubject());
        dto.setWebLink(entity.getWebLink());
        dto.setHasAttachments(entity.isHasAttachments());
        dto.setRead(entity.isRead());
        dto.setBody(entity.getBody());
        dto.setToRecipients(entity.getToRecipients());
        dto.setImportance(entity.getImportance());

        return dto;
    }

    public List<EmailDto> mapEntityToDtoList(List<EmailEntity> emails) {
        return emails.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public EmailEntity mapDtoToEntity(EmailDto dto) {

        EmailEntity entity = new EmailEntity();
        entity.setId(dto.getId());
        entity.setUserId(dto.getUserId());
        entity.setInternetMessageId(dto.getInternetMessageId());
        entity.setCreatedDateTime(dto.getCreatedDateTime());
        entity.setLastModifiedDateTime(dto.getLastModifiedDateTime());
        entity.setSendDateTime(dto.getSendDateTime());
        entity.setReceivedDateTime(dto.getReceivedDateTime());
        entity.setBodyPreview(dto.getBodyPreview());
        entity.setFromEmailAddress(dto.getFromEmailAddress());
        entity.setToRecipients(dto.getToRecipients());
        entity.setSenderEmailAddress(dto.getSenderEmailAddress());
        entity.setSubject(dto.getSubject());
        entity.setWebLink(dto.getWebLink());
        entity.setHasAttachments(dto.isHasAttachments());
        entity.setRead(dto.isRead());
        entity.setBody(dto.getBody());
        entity.setToRecipients(dto.getToRecipients());
        entity.setImportance(dto.getImportance());

        return entity;
    }
}
