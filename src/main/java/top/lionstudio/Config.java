package top.lionstudio;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import top.lionstudio.interceptor.LoginInterceptor;



@Configuration
public class Config  implements  WebMvcConfigurer {
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//这里可以添加多个拦截器
		//主拦截器  检查 session
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/meeting/*");
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/vote/*");
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/test");
	}

}
