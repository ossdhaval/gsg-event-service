package com.gsg.event.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;


@Configuration
public class GSGWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity hs) throws Exception
    {
        hs.
                headers().frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .logout().logoutUrl("/loggedout");
//        .successHandler(new GSGAuthenticationSuccessHandler())
    }

    @Override
    public void configure(WebSecurity webSecurity){
        webSecurity.ignoring().mvcMatchers("/css/**", "/webjars/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder amb) throws Exception {
        amb.inMemoryAuthentication().withUser("dd").password("{noop}dd").roles("ADMIN");
    }

}
