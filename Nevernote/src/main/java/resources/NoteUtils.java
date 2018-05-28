package resources;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dto.Note;
import dto.Notebook;

public class NoteUtils {
	
	public static ResponseEntity<Note> createNote(Note newnote, String notebook){
		
		if (newnote.getBody() == null || newnote.getTitle() == null) {
			newnote = new Note();
			newnote.setTitle("Invalid Request. Note not added");
			return new ResponseEntity<Note>(newnote,HttpStatus.FORBIDDEN);
		}
		
		if(!NotebookUtils.notebooks.containsKey(notebook))
			return InvalidNotebook();
		
		newnote.setTime_created(LocalDateTime.now());
		newnote.setLast_modified(LocalDateTime.now());
		
		if (!NotebookUtils.notebooks.get(notebook).addNote(newnote)) {
			newnote = new Note();
		    newnote.setTitle("Note already exists. Note not added");
		    return new ResponseEntity<Note>(newnote,HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<Note>(newnote,HttpStatus.CREATED);
	}
	
	public static ResponseEntity<Note> readNote(String name, String notebook){
		
		if (!NotebookUtils.notebooks.containsKey(notebook))
			return InvalidNotebook();
		
		Note note = NotebookUtils.notebooks.get(notebook).getNote(name);
		
		if (note == null) {
			note = new Note();
			note.setTitle("Note does not exist");
			return new ResponseEntity<Note>(note,HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<Note>(note,HttpStatus.OK);
	}
	
	
	public static ResponseEntity<Note> updateNote(Note newnote, String notebook){
		
		if (newnote.getTitle() == null) {
			newnote = new Note();
			newnote.setTitle("Invalid Request. Note not updated");
			return new ResponseEntity<Note>(newnote,HttpStatus.FORBIDDEN);
		}
		
		if(!NotebookUtils.notebooks.containsKey(notebook))
			return InvalidNotebook();
		
		Note note = NotebookUtils.notebooks.get(notebook).updateNote(newnote);
		
		if (note == null) {
			newnote = new Note();
		    newnote.setTitle("Note does not exists. Note not updated");
		    return new ResponseEntity<Note>(newnote,HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<Note>(note,HttpStatus.OK);
	}
	
	public static ResponseEntity<Note> deleteNote(String name, String notebook){
		
		if (!NotebookUtils.notebooks.containsKey(notebook))
			return InvalidNotebook();
		
		Note note = NotebookUtils.notebooks.get(notebook).removeNote(name);
		
		if (note == null) {
			note = new Note();
		    note.setTitle("Note does not exists.");
		    return new ResponseEntity<Note>(note,HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<Note>(note,HttpStatus.OK);
	}
	
	public static ResponseEntity<Note> InvalidNotebook(){
			Note newnote = new Note();
			newnote.setTitle("Notebook does not exists");
			return new ResponseEntity<Note>(newnote,HttpStatus.NOT_FOUND);
	}

	
}
