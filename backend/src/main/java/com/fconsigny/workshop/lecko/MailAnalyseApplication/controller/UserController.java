package com.fconsigny.workshop.lecko.MailAnalyseApplication.controller;


import com.fconsigny.workshop.lecko.MailAnalyseApplication.dto.UserDto;
import com.fconsigny.workshop.lecko.MailAnalyseApplication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @ResponseBody
    public UserDto findOne(@PathVariable String id) {
       return userService.findOneById(id);
    }

    @GetMapping(value = "/{userId}/pictures",produces = MediaType.IMAGE_JPEG_VALUE)
    @CrossOrigin
    @ResponseBody
    public byte[] getProfilePicture(@PathVariable  String userId) throws IOException {
        File file = new File(userId + ".jpg");

        if(file.exists()) {
            InputStream inputStream = new FileInputStream(file);
            return inputStream.readAllBytes();
        }

        else{
            Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.info("Enable to find the requested picture");
            return null;
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteOne(String id) {
        userService.deleteById(id);
    }
}
