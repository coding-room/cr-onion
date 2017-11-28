package cr.onion;

import cr.onion.config.SiteConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableSpringConfigured
@EnableConfigurationProperties(SiteConfig.class)
public class OnionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnionApplication.class, args);
	}
}
