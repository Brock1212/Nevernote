package dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Notebook {

	 private String name; 
	 private ArrayList<Note> notes = new ArrayList<Note>();
	 
	 public Notebook(String name){
		 
		 this.name = name;
		 
	 }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}
	
	
	public boolean addNote(Note note) {
		
		for (int i = 0; i < notes.size(); ++i) {
			if (notes.get(i).getTitle().equals(note.getTitle()) )
				return false;
		}
		
		notes.add(note);
		return true;
		
	}
	
	public Note getNote(String title) {
		for (int i = 0; i < notes.size(); ++i) {
			if (notes.get(i).getTitle().equals(title) )
				return notes.get(i);
		}
		
		return null;
		
	}
	
	public Note updateNote(Note note) {
		
		if (getNote(note.getTitle()) == null)
			return null;
		
		for (int i = 0; i < notes.size(); ++i) {
			if (notes.get(i).getTitle().equals(note.getTitle())) {
				
				
				if (note.getBody() != null && !note.getBody().isEmpty()) {
					if ( !notes.get(i).getBody().equals(note.getBody())) {
						notes.get(i).setBody(note.getBody());
					}
				}
				
				if (!(note.getTags() == null) && !notes.get(i).getTags().equals(note.getTags())) {
					notes.get(i).setTags(note.getTags());
				}
				
				notes.get(i).setLast_modified(LocalDateTime.now());
				
				return notes.get(i);
				
			}
				
		}
		return null;
	}
	
	public Note removeNote(String title) {
		
		for (int i = 0; i < notes.size(); ++i) {
			if (notes.get(i).getTitle().equals(title) )
				return notes.remove(i);
		}
		
		return null;
		
	}

	public Notebook filteredBook(String tag) {
		
		Notebook newbook = new Notebook(this.name);
		
		for (int i = 0; i < notes.size(); ++i) {
			if (notes.get(i).getTags().contains(tag))
				newbook.addNote(notes.get(i));
		}
		
		return newbook;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
