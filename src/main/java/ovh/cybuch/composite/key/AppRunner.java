package ovh.cybuch.composite.key;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class AppRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);
		System.out.println(context.getEnvironment().getProperty("spring.data.mongodb.database"));
	}
}
