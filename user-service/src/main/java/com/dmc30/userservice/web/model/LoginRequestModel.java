package com.dmc30.userservice.web.model;

import lombok.Data;

@Data
public class LoginRequestModel {

    private String email;
    private String password;
}
