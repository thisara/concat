package com.concat.model;

import org.springframework.data.annotation.Id;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author thisara
 *
 */

public class Summary {

	@Id	
	private int id;
	
	private String summary;
	
	private String originalText;

	private String userIdentity;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getOriginalText() {
		return originalText;
	}

	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}

	@Override
	public String toString(){
		return "id="+id+", summary="+summary+", originalText="+originalText+", userIdentity="+userIdentity;
	}
}
