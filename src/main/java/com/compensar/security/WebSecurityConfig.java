package com.compensar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.compensar.security.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService usuarioDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// .httpBasic(withDefaults()) // (1)
				.csrf().disable() // (2)
				.authorizeRequests().antMatchers("/publico/**").permitAll().antMatchers("/users/**").hasRole("USER")
				.antMatchers("/users/**").hasRole("ADMIN").antMatchers("/admin/**").hasRole("ADMIN").anyRequest()
				.authenticated().and().cors().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		From database
		auth.userDetailsService(usuarioDetailsService);

//		auth.inMemoryAuthentication().withUser("jcabelloc").password("{noop}" + "secreto").roles("USER").and()
//				.withUser("mlopez").password("secreto").roles("ADMIN").and().withUser("edwin")
//				.password("secreto").roles("ADMIN");

	}

}