package br.com.projetoSA.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import br.com.projetoSA.security.ProjetoDetailsService;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ProjetoDetailsService projetoDetailsService;
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http

				// Habilitar ou desabilitar paginas

				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/mercado/**").permitAll()// hasAnyRole("admin")
				.antMatchers("/usuario/**").permitAll()
				

				// Habilitar statics

				.antMatchers("/bootstrap-4.5.2/**").permitAll()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/fontawesome-free-5.15.1-web/**").permitAll()
				.antMatchers("/jquery-3.5.1/**").permitAll()
				.antMatchers("/js/**").permitAll()
				.antMatchers("/images/**").permitAll()

				// Outras autenticações

				.anyRequest().authenticated().and()

				// Definir página de login

				.formLogin().loginPage("/login").defaultSuccessUrl("/produto/list", true).permitAll().and()

				// Relembrar usuário logado

				.rememberMe();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(projetoDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource);
		return jdbcUserDetailsManager;
	}
	
}