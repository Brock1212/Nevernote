package controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.Note;
import dto.Notebook;
import resources.NoteUtils;
import resources.NotebookUtils;

@RestController
public class NoteController {
	
	@RequestMapping(value = "/create-note", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Note> create(@RequestBody Note payload, @RequestParam(value="name")String notebook) {
		
		
		return NoteUtils.createNote(payload,notebook);
		
	}
	
	@RequestMapping(value = "/get-note", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Note> read( @RequestBody Map<String, String> payload) {
		
		
		return NoteUtils.readNote(payload.get("title"),payload.get("notebook"));
		
	}
	
	@RequestMapping(value = "/update-note", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Note> update( @RequestBody Note payload,  @RequestParam(value="name")String notebook) {
		
		
		return NoteUtils.updateNote(payload,notebook);
		
	}
	
	@RequestMapping(value = "/delete-note", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Note> delete( @RequestBody Map<String, String> payload) {
		
		
		return NoteUtils.deleteNote(payload.get("title"),payload.get("notebook"));
		
	}

}
