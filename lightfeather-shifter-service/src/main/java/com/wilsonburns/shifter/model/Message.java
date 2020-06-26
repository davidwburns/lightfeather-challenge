package com.wilsonburns.shifter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	
	@JsonProperty("Shift")
	private Integer shift;
	
	@JsonProperty("Message")
	private String message;

	public Integer getShift() {
		return shift;
	}

	public void setShift(Integer shift) {
		this.shift = shift;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}	
