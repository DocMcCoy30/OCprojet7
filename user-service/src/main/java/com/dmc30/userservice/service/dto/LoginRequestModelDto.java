package com.dmc30.userservice.service.dto;

import lombok.Data;

@Data
public class LoginRequestModelDto {

    private String email;
    private String password;
}
