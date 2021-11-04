package com.fconsigny.workshop.lecko.MailAnalyseApplication.mapper;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.EmailDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.EmailEntity;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.requests.MessageCollectionPage;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class EmailMapper {

    public EmailEntity mapGraphCollectionToEntity(Message message) {

        EmailEntity entity = new EmailEntity();
        entity.setId(message.id);
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

        return entity;
    }

    public List<EmailEntity> mapGraphCollectionToEntity(MessageCollectionPage collectionPage) {
        List<Message> messages = collectionPage.getCurrentPage();
        return messages.stream()
                .map(this::mapGraphCollectionToEntity)
                .collect(Collectors.toList());
    }

    public EmailDto mapEntityToDto(EmailEntity entity) {
        EmailDto dto = new EmailDto();
        dto.setId(entity.getId());
        dto.setInternetMessageId(entity.getInternetMessageId());
        dto.setCreatedDateTime(entity.getCreatedDateTime());
        dto.setLastModifiedDateTime(entity.getLastModifiedDateTime());
        dto.setSendDateTime(entity.getSendDateTime());
        dto.setReceivedDateTime(entity.getReceivedDateTime());
        dto.setBodyPreview(entity.getBodyPreview());
        dto.setFromEmailAddress(entity.getFromEmailAddress());
        dto.setSenderEmailAddress(entity.getSenderEmailAddress());
        dto.setSubject(entity.getSubject());
        dto.setWebLink(entity.getWebLink());
        dto.setHasAttachments(entity.isHasAttachments());
        dto.setRead(entity.isRead());

        return dto;
    }

    public List<EmailDto> mapEntityToDtoList(List<EmailEntity> emails) {
        return emails.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
