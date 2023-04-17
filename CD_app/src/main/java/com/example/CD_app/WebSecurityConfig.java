package com.example.CD_app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import org.springframework.beans.factory.annotation.Autowired;

@Configuration  
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;	

	@Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	       http
	        .authorizeHttpRequests()
	        	.requestMatchers("/css/**", "/artistlist","/albumlist", "/login*").permitAll() 
	        	.anyRequest().authenticated()
	        	.and()
	      .formLogin()
	          .defaultSuccessUrl("/albumlist", true)
	          .permitAll()
	          .and()
	      .logout()
	          .permitAll()
	          .and()
	     .httpBasic();
	     return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    

}


