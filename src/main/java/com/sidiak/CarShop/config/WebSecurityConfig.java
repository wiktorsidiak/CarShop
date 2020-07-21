package com.sidiak.CarShop.config;

import com.sidiak.CarShop.service.User.UserServiсe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserServiсe userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/", "/registration", "/login")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/cars")
				.failureUrl("/login?error=true")
				.permitAll()
				.and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/403")
				.and()
				.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



}