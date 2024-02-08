package com.naresh.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tickets")
public class Ticket {

	@Id
	private String id;
	private String title;
	private String description;
	private String status;
	private String userEmail;
	public Ticket() {
		super();
	}
	public Ticket(String id, String title, String description, String status, String userEmail) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.userEmail = userEmail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", userEmail=" + userEmail + "]";
	}

	
}
