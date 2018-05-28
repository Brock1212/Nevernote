package controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.Notebook;
import resources.NotebookUtils;

@RestController
public class NotebookController {
	
	@RequestMapping(value = "/create-notebook", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Notebook> create(@RequestBody Map<String, String> payload) {
		
		return NotebookUtils.createNotebook(payload.get("name"));
		
	}
	
	@RequestMapping(value = "/get-notebook", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Notebook> get(@RequestBody Map<String, String> payload) {
		
		return NotebookUtils.getNotebook(payload.get("name"), payload.get("tag"));
		
	}

	@RequestMapping(value = "/delete-notebook", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Notebook> delete(@RequestParam(value="name")String name) {
		
		return NotebookUtils.deleteNotebook(name);
		
	}
}
