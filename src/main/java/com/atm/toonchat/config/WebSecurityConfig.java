package com.atm.toonchat.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import com.atm.toonchat.service.UserDetailService;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

	private final UserDetailService userService;

	//스프링 시큐리티 기능 비활성화
	@Bean
	public WebSecurityCustomizer configure() {
		return (web) -> web.ignoring()
			.requestMatchers(toH2Console())
			.requestMatchers("/static/**");
	}

	//특정 http 요청에 대한 웹 기반 보안 구성
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			.authorizeRequests()//인증, 인가 설정
			.requestMatchers("/login", "/signup", "/user").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin(formLogin -> formLogin //폼 기반 로그인 설정
				.loginPage("/login")
				.defaultSuccessUrl("/articles")
			)
			.logout(logout -> logout // 로그아웃 설정
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true)
			)
			.csrf(AbstractHttpConfigurer::disable) //csrf 비활성화
			.build();
	}

	//인증 관리자 관련 설정
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() throws Exception {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userService);
		daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());

		return daoAuthenticationProvider;
	}

	//패스워드 인코더로 사용할 빈 드록
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}