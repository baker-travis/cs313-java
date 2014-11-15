package forum.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {

	private String username;

	private String time;

	private String text;

	public Post() {
		super();
	}

	public Post(String username, String time, String text) {
		super();
		this.username = username;
		this.time = time;
		this.text = text;
	}
	
	public Post(String username, Date time, String text) {
		super();
		this.username = username;
		this.setTime(time);
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public void setTime(Date time) {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.time = format.format(time);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String toFileString() {
		return text + "::--::" + time + "::--::" + username;
	}
	
	public void loadFromFileString(String str) {
		String[] parts = str.split("::--::");

        text = parts[0];
        time = parts[1];
        username = parts[2];
	}
}
