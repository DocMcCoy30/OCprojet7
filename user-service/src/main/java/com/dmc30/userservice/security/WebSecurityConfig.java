package com.dmc30.userservice.security;

import com.dmc30.userservice.service.contract.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UsersService usersService;
    private final Environment environment;
    private final PasswordEncoderHelper passwordEncoderHelper;

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
//                .logout().logoutUrl("/logout")
//                .and()
                .logout().deleteCookies("JSESSIONID")
                .and()
                .addFilter(getAuthenticationFilter());

    }

//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }


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
