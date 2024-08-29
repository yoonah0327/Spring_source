package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//클라이언트요청 >> 필터 + 필터.. + dispatcherServlet
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		//인증없이 접근 가능 요청(url)
		String[] whiteList = {
			"/", "/notice", "/user/loginform", "/user/login_fail", "/user/expired", "/shop"
		};
		httpSecurity
			.csrf(csrf -> csrf.disable()) //csrf 사용안하기
			.authorizeHttpRequests(config -> 
					config
						.requestMatchers(whiteList).permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN") //특정 권한을 가진 사용자만 접근 허용
						.requestMatchers("/staff/**").hasAnyRole("ADMIN", "STAFF")
						.anyRequest().authenticated()
						)
			.formLogin(config -> 
				config
					.loginPage("/user/required_loginform")
					.loginProcessingUrl("/user/login") //시큐리티가 자동으로 로그인 처리르 해줄 요청 경로 설정
					.usernameParameter("userName") //이때 username과 password를 알려야함
					.passwordParameter("password")
					.successHandler(new AuthSuccessHandler()) //로그인 성공 이후 뭔가를 처리할것이있다면 핸들러를 등록해서 처리한다
					.permitAll()
			)
			.logout(config -> 
				config
					.logoutUrl("/user/logout") //시큐리티가 자동으로 로그아웃처리 해줄 경로 설정 
					.logoutSuccessUrl("/")
					.permitAll()
			)
			.exceptionHandling(config -> //인증 처리중 예외가 발생했을때 설정. 권한 확인과정에서 예외가 발생한경우
				config
					.accessDeniedPage("/user/denied") // 시큐리티는 에러인 경우 403 forbidden을 발생시킴. 이때 이동할 경로 설정.
					
				)
			.sessionManagement(config -> 
				config
					.maximumSessions(0) //최대허용 세션갯수
					.expiredUrl("/user/expired") //세션 허용 갯수가 넘어서 로그인이 해제된경우 리다이렉트할 경로 지정
				);
			return httpSecurity.build();
	}
}
