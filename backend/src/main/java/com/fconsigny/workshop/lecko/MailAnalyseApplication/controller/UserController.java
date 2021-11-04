package com.fconsigny.workshop.lecko.MailAnalyseApplication.controller;


import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.UserDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.mapper.UserMapper;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    @ResponseBody
    public List<UserDto> findAll() {
        return userMapper.mapEntityToDtoList(userService.findAll());
    }
}
