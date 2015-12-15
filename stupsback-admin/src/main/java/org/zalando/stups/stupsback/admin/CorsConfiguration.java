package org.zalando.stups.stupsback.admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author jbellmann
 *
 */
// TODO, does not work as expected, use Cors-Filter
//@Configuration
//@EnableWebMvc
public class CorsConfiguration {

//	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedOrigins("http://localhost")
				.allowedMethods("PUT", "DELETE", "GET", "POST")
//				.allowedHeaders("header1", "header2", "header3")
//				.exposedHeaders("header1", "header2")
				.allowCredentials(false)
				.maxAge(3600);
			}
		};
	}

}
