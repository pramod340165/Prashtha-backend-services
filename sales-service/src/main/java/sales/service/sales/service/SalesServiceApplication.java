package sales.service.sales.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
 
@Configuration
@EnableJpaAuditing
@ComponentScan(basePackages={"com.pfpl.sales"})
@EnableJpaRepositories(basePackages={"com.pfpl.sales"})
@EnableAutoConfiguration
@EntityScan("com.pfpl.sales.entity")
@EnableScheduling
@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
public class SalesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesServiceApplication.class, args);
	}

}
