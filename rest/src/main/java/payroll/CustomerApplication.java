package payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String... args) {
		final ConfigurableApplicationContext run = run(CustomerApplication.class, args);
	}
}
