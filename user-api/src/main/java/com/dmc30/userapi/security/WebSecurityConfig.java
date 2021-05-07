package com.dmc30.userapi.security;

import com.dmc30.userapi.service.contract.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UsersService usersService;
    private Environment environment;
    private PasswordEncoderHelper passwordEncoderHelper;

    @Autowired
    public WebSecurityConfig(UsersService usersService, Environment environment, PasswordEncoderHelper passwordEncoderHelper) {
        this.usersService = usersService;
        this.environment = environment;
        this.passwordEncoderHelper = passwordEncoderHelper;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //connect to h2 console
        http.headers().frameOptions().disable();
        http.authorizeRequests().antMatchers("/users/**").permitAll()
        .and()
        .addFilter(getAuthenticationFilter());

    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(usersService, environment, authenticationManager());
//        authenticationFilter.setAuthenticationManager(authenticationManager());
        authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"));
        return authenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(passwordEncoderHelper.bCryptPasswordEncoder());
    }
}
