package restApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * This is the main application class responsible to start spring boot REST API
 * application.
 * 
 * @author Deval Bibodi
 * 
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);

	}

	/**
	 * This is main method to run spring boot REST API application.
	 * 
	 * @param args
	 *            - Arguments for running application if any.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
