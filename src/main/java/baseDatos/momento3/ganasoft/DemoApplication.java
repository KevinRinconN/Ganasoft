package baseDatos.momento3.ganasoft;

import baseDatos.momento3.ganasoft.View.PrincipalPage;
import baseDatos.momento3.ganasoft.View.bovinos.RegistrarBovino;
import baseDatos.momento3.ganasoft.View.bovinos.VentanaAgregarParentesco;
import baseDatos.momento3.ganasoft.controller.Controller;
import baseDatos.momento3.ganasoft.model.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@EntityScan(basePackages = {"baseDatos.momento3.ganasoft.model"})
@SpringBootApplication
public class DemoApplication {

	@Autowired
	private AnimalRepository animalRepository;

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
	}
	@Bean
	ApplicationRunner applicationRunner(){
		return args -> {

			Controller controlador = new Controller(animalRepository);
		};
	}


}
