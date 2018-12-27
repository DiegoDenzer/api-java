package com.diegodenzer.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Usuario e senha em memoria para testes
		auth.inMemoryAuthentication()
			.withUser("admin").password(passwordEncoder().encode("admin")).roles("ROLE");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/categorias").permitAll() // todos tem acesso as categorias 
			.anyRequest().authenticated() // Todas(any) demais precisão de autenticação
			.and()
			.httpBasic() // Tipo authenticação vai ser basica
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Api não vai guardar sessao nenhuma 
			.and()
			.csrf().disable();
	}
	
}
