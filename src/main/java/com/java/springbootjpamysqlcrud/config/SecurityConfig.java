package com.java.springbootjpamysqlcrud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("nar").password("{noop}nar").roles("USER").and()
                .withUser("deep").password("{noop}deep").roles("ADMIN");

        // Was getting java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
        // Added {noop} for this
    }

    /*@Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("**/secured/**").authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .httpBasic();

        http.csrf().disable();

        //----Permit all request
        /*http.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .httpBasic();*/

    }
}
