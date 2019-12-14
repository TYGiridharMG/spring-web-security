package com.tyss.springwebsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder()
				.username("user").password("user").roles("ADMIN").build());
		return manager;
	}
	
//    public void configure(HttpSecurity http) throws Exception {
//    	http.authorizeRequests().anyRequest().authenticated()  
//    	.and().formLogin().and().httpBasic();  
//    }

	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/index").permitAll()
				.and().authorizeRequests()
				.antMatchers("/admin")//.hasRole("ADMIN")//.anyRequest()
				.authenticated()
				.and().formLogin()
				.loginPage("/login")
				.and().rememberMe().key("rememberMe")
				.rememberMeParameter("remember")
				.rememberMeCookieName("remember")
				.tokenValiditySeconds(10000000)
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/index");
	}
}
