package nevernote;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import controllers.NoteController;
import controllers.NotebookController;
import dto.Notebook;

@SpringBootApplication
@ComponentScan(basePackageClasses = NotebookController.class)
@ComponentScan(basePackageClasses = NoteController.class)
public class NevernoteApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NevernoteApplication.class, args);
	}
}
