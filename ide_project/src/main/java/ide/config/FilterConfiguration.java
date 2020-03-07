package ide.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ide.com.filter.CORSFilter;

@Configuration
public class FilterConfiguration implements WebMvcConfigurer {
	
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CORSFilter());
		registrationBean.setOrder(Integer.MIN_VALUE);
		//registrationBean.addUrlPatterns("/*");
		registrationBean.setUrlPatterns(Arrays.asList("/board/*"));
		return registrationBean;
	}
}