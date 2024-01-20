package com.nobroker.controller;


import com.nobroker.payload.UserDto;
import com.nobroker.service.EmailService;
import com.nobroker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {
//http://localhost:8080/api/register
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public Map<String, String> createUser(@RequestBody UserDto userDto) {
        UserDto user = userService.createUser(userDto);
        return emailService.sendOtpEmail(userDto.getEmail());
    }


}
