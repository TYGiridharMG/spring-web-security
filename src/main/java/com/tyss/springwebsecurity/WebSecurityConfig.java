package com.tyss.springwebsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
//	@SuppressWarnings("deprecation")
//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.builder()
//				.username("admin").password("admin").roles("ADMIN").build());
//		manager.createUser(User.builder()
//				.username("user").password("user").roles("USER").build());
//		return manager;
//	}
	

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER")
//		.and().withUser("admin").password("admin").roles("ADMIN");
//	}

//    public void configure(HttpSecurity http) throws Exception {
//    	http.authorizeRequests().anyRequest().authenticated()  
//    	.and().formLogin().and().httpBasic();  
//    }
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/index").permitAll()
				.and().authorizeRequests()
				.antMatchers("/admin").access("hasRole('ADMIN')")//.anyRequest().hasRole("ADMIN").anyRequest()
				//.authenticated()
				.antMatchers("/user").access("hasRole('USER')")//.anyRequest().hasRole("USER").anyRequest()
				//.authenticated()
				.and().formLogin()
				.loginPage("/login")
				.and().rememberMe().key("rem-me-key")
				.rememberMeParameter("remember")
				.rememberMeCookieName("remember")
				.tokenValiditySeconds(10000000)
				.and().logout().deleteCookies("JSESSIONID")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/index");
	}
}