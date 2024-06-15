package com.example.springboot.demosecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	/*
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails john = User.builder()
				.username("john")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails mary = User.builder()
				.username("mary")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();
		
		UserDetails susan = User.builder()
				.username("susan")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(john, mary, susan);
	}
	*/
	
	
	//jdbc default
	/*
	@Bean
	public UserDetailsManager userDetailsManager(DataSource datasource) {
		return new JdbcUserDetailsManager(datasource);
	}
	*/
	
	//jdbc custom table
	@Bean
	public UserDetailsManager userDetailsManager(DataSource datasource) {
		JdbcUserDetailsManager jd = new JdbcUserDetailsManager(datasource);
		jd.setUsersByUsernameQuery("select username, password, enabled from employee_members where username=?");
		jd.setAuthoritiesByUsernameQuery("select username, authority from employee_roles where username=?");
		return jd;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer->
		configurer
		.requestMatchers("/").hasRole("EMPLOYEE")
		.requestMatchers("/leaders/**").hasRole("MANAGER") //** indicate subdirectory
		.requestMatchers("/systems/**").hasRole("ADMIN")
		.anyRequest().authenticated())
		.formLogin(form ->
					form.loginPage("/showMyLoginPage")
						.loginProcessingUrl("/authenticateTheUser")
						.permitAll()
		)
		.logout(logout -> logout.permitAll())
		.exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));
		return http.build();
	}
}
