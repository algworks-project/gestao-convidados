package com.algworks.gestaofesta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class InMemorySecurityConfig {
	//https://stackoverflow.com/questions/49654143/spring-security-5-there-is-no-passwordencoder-mapped-for-the-id-null#answer-56490819
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("joao").password("{noop}123").roles("USER")
			.and()
			.withUser("alexandre").password("{noop}123").roles("USER")
			.and()
			.withUser("thiago").password("{noop}123").roles("USER");
	}
}