package com.nobroker.payload;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String mobile;
    private boolean emailVerification;
}
