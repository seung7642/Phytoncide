package com.pangtrue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // 스프링 MVC 설정을 활성화한다. 이 설정을 사용하지 않고 설정 코드를 직접 작성하려면 백 여 줄에 가까운 코드를 입력해야 한다.
public class MvcConfig implements WebMvcConfigurer {

	@Override // DispatcherServlet의 매핑 경로를 '/'로 주었을 때, 올바르게 처리하기 위한 설정을 추가한다.
	public void configureDefaultServletHandling( 
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	// WebMvcConfigurer 인터페이스에 정의된 configureViewResolvers() 메서드는 
	// ViewResolverRegistry 타입의 registry 파라미터를 갖는다.
	// ViewResolverRegistry#jsp() 메서드를 사용하면 JSP를 위한 ViewResolver를 설정할 수 있다.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}
}
