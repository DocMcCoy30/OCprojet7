package com.dmc30.userapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderHelper {

    public String passwordEncoder(String pPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(pPassword);
    }

    public boolean comparePassword (String candidatePassword, String hashedPassword) {
        boolean pwCheck;
        pwCheck = BCrypt.checkpw(candidatePassword, hashedPassword);
        return pwCheck;
    }
}
