package edu.gae.secret.communicator.model;

import java.util.Date;

import com.google.apphosting.api.DatastorePb.GetResponse.Entity;

public class Message {

	private String content;
	private Date date;

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

	public Message(String content, Date date) {
		super();
		this.content = content;
		this.date = date;
	}
	
	public Message(){
		
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
