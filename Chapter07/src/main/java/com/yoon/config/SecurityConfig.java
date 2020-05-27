package com.yoon.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private BoardUserDetailsService boardUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		// authorizeRequests() : 사용자 인증과 권한을 설정
		// antMatchers("URL 패턴") : 매칭되는 url 패턴들에 대한 접근 허용(permitAll은 모든 사용자, hasRole은 특정 권한 사용자)
		security.authorizeRequests().antMatchers("/").permitAll();
		security.authorizeRequests().antMatchers("/member/**").authenticated();
		security.authorizeRequests().antMatchers("/manager/**").hasAnyRole("MANAGER");
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		// csrf() : 크로스사이트 위조 요청의 대한 설정. RESTfull을 사용하기 위해서는 disable 처리를 해야함.
		security.csrf().disable();
		
		// formLogin() : 로그인 페이지 설정
		// defaultSuccessUrl() : 로그인이 완료되면 이동할 페이지
		// accessDeniedPage : 인증되지 않은 사용자의 대한 page
		security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		
		security.userDetailsService(boardUserDetailsService);
	}
	
	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		// inMemoryAuthentication : 메모리에 사용자 정보를 생성하는 메소드
		// withUser : 생성될 사용자 아이디
		// password : 비밀번호 생성 {noop}는 비밀번호에 대한 암호화 처리 안함.
		// roles : 권한 설정
		// 		auth.inMemoryAuthentication().
		//		withUser("manager").
		//		password("{noop}manager123").
		//		roles("MANAGER");
		//		
		//		auth.inMemoryAuthentication().
		//		withUser("admin").
		//		password("{noop}admin123").
		//		roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
