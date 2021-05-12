package com.dmc30.userservice.security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderHelper {

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String encodePwd(String pPassword) {
        return bCryptPasswordEncoder().encode(pPassword);
    }

    public boolean comparePassword (String candidatePassword, String hashedPassword) {
        boolean pwCheck;
        pwCheck = BCrypt.checkpw(candidatePassword, hashedPassword);
        return pwCheck;
    }
}
