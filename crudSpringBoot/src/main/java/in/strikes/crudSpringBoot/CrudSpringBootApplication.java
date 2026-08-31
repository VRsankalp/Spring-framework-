package in.strikes.crudSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudSpringBootApplication.class, args);
		System.out.println("Student Saved Successfully");
	}

}
