package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.rest.webmvc.RepositoryRestHandlerMapping;

import com.sec.web.SettingUrlResController;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		SettingUrlResController s = context.getBean(SettingUrlResController.class);
		s.SettingUrlRes();
//		RepositoryRestHandlerMapping r = context.getBean(RepositoryRestHandlerMapping.class);
//		s.SettingUrlRes(r.getHandlerMethods());
	}
	
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {  
        return builder.sources(DemoApplication.class);  
    }  
      
    public void customize(ConfigurableEmbeddedServletContainer container) {  
        container.setPort(8080);  
    } 
}
