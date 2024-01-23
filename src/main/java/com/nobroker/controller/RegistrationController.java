package com.nobroker.controller;


import com.nobroker.payload.UserDto;
import com.nobroker.service.EmailService;
import com.nobroker.service.UserService;
import com.nobroker.service.impl.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {
//http://localhost:8080/api/register

    private UserService userService;

    private EmailService emailService;

    private EmailVerificationService emailVerificationService;

    public RegistrationController(UserService userService, EmailService emailService, EmailVerificationService emailVerificationService) {
        this.userService = userService;
        this.emailService = emailService;
        this.emailVerificationService = emailVerificationService;
    }

    @PostMapping("/register")
    public Map<String, String> createUser(@RequestBody UserDto userDto) {
        UserDto user = userService.createUser(userDto);
        return emailService.sendOtpEmail(userDto.getEmail());
    }

    //http://localhost:8080/api/verify-otp?email=&otp=
    @PostMapping("/verify-otp")
    public Map<String, String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        return emailVerificationService.verifyOtp(email, otp);
    }

}
