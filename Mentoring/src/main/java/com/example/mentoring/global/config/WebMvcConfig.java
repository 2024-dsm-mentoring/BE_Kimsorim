package com.example.mentoring.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration     // 설정 파일임을 알려줌
public class WebMvcConfig implements WebMvcConfigurer {     // CORS 설정을 위해 사용
                                    // 인터페이스를 구현하여 Spring MVC 커스터마이징할 수 있음
    @Override
    public void addCorsMappings(CorsRegistry registry) {     // CORS 설정을 추가하는 메소드
        registry.addMapping("/**")     // 모든 경로에 대해 CORS 허용
                .allowedOrigins("*")     // 모든 도메인에서의 요청 허용
                .allowedMethods("*")     // 모든 HTTP 메소드 허용
                .allowedHeaders("*");     // 모든 헤더 허용
    }
}
// 이 설정을 통해 애플리케이션의 모든 경로에 대해 모든 도메인, 메소드, 헤더에서 오는 요청을
// 허용하게 됨. 이는 외부에서 자유롭게 접근할 수 있도록 하기 위함임