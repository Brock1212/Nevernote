package resources;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dto.Notebook;

public class NotebookUtils {
	
	public static HashMap<String,Notebook> notebooks = new HashMap<String,Notebook>();
	
	public static ResponseEntity<Notebook> createNotebook(String name) {
		
		if (name == null)
			return new ResponseEntity<Notebook>(new Notebook("Invalid Request. Notebook not added"),HttpStatus.FORBIDDEN);
		else if(notebooks.containsKey(name)) {
			return new ResponseEntity<Notebook>(new Notebook("Notebook with this name already exist. Notebook not added"),HttpStatus.FORBIDDEN);
		}
		
		Notebook newbook = new Notebook(name);
		notebooks.put(name,newbook);
		return new ResponseEntity<Notebook>(newbook,HttpStatus.CREATED);
		
	}

	public static ResponseEntity<Notebook> deleteNotebook(String name) {
		
		if (!notebooks.containsKey(name))
			return new ResponseEntity<Notebook>(new Notebook("Notebook does not exist"),HttpStatus.NOT_FOUND);
		
		Notebook newbook = notebooks.remove(name);
		newbook.setName(name + " was succesfully deleted");
		return new ResponseEntity<Notebook>(newbook,HttpStatus.OK);
		
		
	}
	
	public static ResponseEntity<Notebook> getNotebook(String name, String tag ) {
		if (!notebooks.containsKey(name))
			return new ResponseEntity<Notebook>(new Notebook("Notebook does not exist"),HttpStatus.NOT_FOUND);
		
		Notebook newbook = notebooks.get(name);
		
		if (tag != null && !tag.isEmpty())
			newbook = newbook.filteredBook(tag);
		
		return new ResponseEntity<Notebook>(newbook,HttpStatus.OK);
		
	}
}
