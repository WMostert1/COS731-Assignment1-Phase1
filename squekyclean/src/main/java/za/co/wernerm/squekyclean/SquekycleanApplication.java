package za.co.wernerm.squekyclean;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SquekycleanApplication {

	public static void main(String[] args) {
		//Do DB migrations
//		Flyway flyway = new Flyway();
//		flyway.setDataSource(configuration.getDbConfiguration().getUrl(),
//				configuration.getDbConfiguration().getUser(),
//				configuration.getDbConfiguration().getPassword());
//
//		flyway.migrate();


		SpringApplication.run(SquekycleanApplication.class, args);
	}
}
