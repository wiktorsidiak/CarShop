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
				.antMatchers("/edit/*", "/delete/*").hasRole("ADMIN")
				.antMatchers("/edit/*", "/create/*").hasRole("USER")
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
		auth.jdbcAuthentication()
				.passwordEncoder(passwordEncoder())
				.dataSource(dataSource)
				.usersByUsernameQuery("SELECT username,password,enabled FROM appuser WHERE username = ?")
				.authoritiesByUsernameQuery("SELECT appuser.username, role.name FROM appuser_role JOIN role ON role.id = appuser_role.roles_id JOIN appuser ON appuser.id = appuser_role.user_id WHERE appuser.username = ?");

	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
}