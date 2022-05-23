/* @<COPYRIGHT>@
 ==================================================
 Copyright 2022.
 Siemens Product Lifecycle Management Software Inc.
 ==================================================
 @<COPYRIGHT>@
*/
package com.siemens.broker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class BrokerSecurityConfig extends WebSecurityConfigurerAdapter {
    //Configuring Basic Auth
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable().authorizeRequests().antMatchers("/v2/**").hasRole("ADMIN").and().httpBasic();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
	return new InMemoryUserDetailsManager(adminUser());
    }

    private UserDetails adminUser() {
	return User.withUsername("admin").password("supersecret").roles("ADMIN").build();
    }

}
