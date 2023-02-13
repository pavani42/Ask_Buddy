package com.hcl.ask_buddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}) 
@EnableSwagger2
public class AskBuddyMsContactUsApplication {

	public static void main(String[] args) {
		System.out.println("Application Started");
		SpringApplication.run(AskBuddyMsContactUsApplication.class, args);
	}
	
//	@Bean
//	public Docket swaggerConfiguration()
//	{
//		Docket d;
//		d = new Docket(DocumentationType.SWAGGER_2)
//				.select()
//			//	.paths(PathSelectors.ant("user/*"))
//				.apis(RequestHandlerSelectors.basePackage("com.hcl.ask_buddy"))
//				.build();
//				
//		return d;
//	}
	
	@Bean
    public Docket askBuddyApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.hcl.ask_buddy")).
                build();
    }

}
