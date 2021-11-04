package com.fconsigny.workshop.lecko.MailAnalyseApplication.mapper;

import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.UserDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.persistence.entity.UserEntity;
import com.microsoft.graph.models.User;
import com.microsoft.graph.requests.UserCollectionPage;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserEntity mapGraphCollectionToEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.id);
        entity.setDisplayName(user.displayName);
        entity.setMail(user.mail);
        entity.setJobTitle(user.jobTitle);
        entity.setMobilePhone(user.mobilePhone);
        entity.setOfficeLocation(user.officeLocation);
        entity.setPreferredLanguage(user.preferredLanguage);
        entity.setGivenName(user.givenName);
        entity.setUserPrincipalName(user.userPrincipalName);
        entity.setSurname(user.surname);
        return entity;
    }

    public List<UserEntity> mapGraphCollectionToEntityList(UserCollectionPage userCollectionPage) {
        List<User> users = userCollectionPage.getCurrentPage();
        return users.stream()
                .map(this::mapGraphCollectionToEntity)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public UserDto mapEntityToDto(UserEntity userEntity) {
        UserDto dto = new UserDto();
        dto.setId(userEntity.getId());
        dto.setDisplayName(userEntity.getDisplayName());
        dto.setMail(userEntity.getMail());
        dto.setJobTitle(userEntity.getJobTitle());
        dto.setMobilePhone(userEntity.getMobilePhone());
        dto.setOfficeLocation(userEntity.getOfficeLocation());
        dto.setPreferredLanguage(userEntity.getPreferredLanguage());
        dto.setGivenName(userEntity.getGivenName());
        dto.setUserPrincipalName(userEntity.getUserPrincipalName());
        dto.setSurname(userEntity.getSurname());
        return dto;
    }

    public List<UserDto> mapEntityToDtoList(List<UserEntity> users) {
        return users.stream().map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
