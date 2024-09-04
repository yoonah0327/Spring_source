package pack;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*") //모든도메인허용
		.allowedMethods("GET", "POST", "PUT", "DELETE") //허용할 HTTP 메소드
		.allowedHeaders("*"); //모든 헤더 허용
	}
}
