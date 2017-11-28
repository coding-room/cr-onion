package cr.onion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableSpringConfigured
public class OnionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnionApplication.class, args);
	}
}
