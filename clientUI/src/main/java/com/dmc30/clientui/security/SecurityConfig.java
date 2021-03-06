package com.dmc30.clientui.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/showAccueil", "/showLivreDetails", "/searchLivresOrAuteurs", "/searchLivreByAuteurs", "/login", "/signin").permitAll()
                .antMatchers("/showProfil", "/update", "/prolongerEmprunt").hasAnyRole("ABONNE", "EMPLOYE")
                .antMatchers("/showEmpruntPage", "/createEmpruntSearchForm", "/createEmprunt", "/searchEmpruntsEnCours", "/retournerEmprunt").hasRole("EMPLOYE")
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied")
        ;

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
