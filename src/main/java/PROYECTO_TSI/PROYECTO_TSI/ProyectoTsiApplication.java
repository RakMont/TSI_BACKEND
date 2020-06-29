package PROYECTO_TSI.PROYECTO_TSI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class ProyectoTsiApplication {

	public static void main(String[] args) throws IOException {
		String web = "src/main/webApp";

		String fileName = "src/main/webApp/podcasts";
		String fileName2 = "src/main/webApp/profiles";
		String fileName3 = "src/main/webApp/historiaHVA";
		String fileName4 = "src/main/webApp/convenios";
		Path path = Paths.get(fileName);
		path=Paths.get(web);
		if (!Files.exists(path)) {
			Files.createDirectory(path);
			System.out.println("web Directory created");
		} else {
			System.out.println("web Directory already exists");
		}
		path = Paths.get(fileName);
		if (!Files.exists(path)) {
			Files.createDirectory(path);
			System.out.println("Directory created");
		} else {
			System.out.println("Directory already exists");
		}
		path=Paths.get(fileName2);
		if (!Files.exists(path)) {
			Files.createDirectory(path);
			System.out.println("Directory created");
		} else {
			System.out.println("Directory already exists");
		}
		path=Paths.get(fileName3);
		if (!Files.exists(path)) {
			Files.createDirectory(path);
			System.out.println("Directory created");
		} else {
			System.out.println("Directory already exists");
		}
		path=Paths.get(fileName4);
		if (!Files.exists(path)) {
			Files.createDirectory(path);
			System.out.println("Directory created");
		} else {
			System.out.println("Directory already exists");
		}

		SpringApplication.run(ProyectoTsiApplication.class, args);
	}

}
