package com.dmc30.clientui.model.bean.utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAuthenticationBean {

    private String username;
//    private String email;
    private String password;
}

