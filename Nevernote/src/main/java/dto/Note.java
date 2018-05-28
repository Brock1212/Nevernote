package dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Note {
	
	private String title;
	private String body;
	private ArrayList<String> tags = new ArrayList<String>();
	private LocalDateTime time_created;
	private LocalDateTime last_modified;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public LocalDateTime getTime_created() {
		return time_created;
	}
	public void setTime_created(LocalDateTime time_created) {
		this.time_created = time_created;
	}
	public LocalDateTime getLast_modified() {
		return last_modified;
	}
	public void setLast_modified(LocalDateTime last_modified) {
		this.last_modified = last_modified;
	}


}
