package com.example.rest.webservices.restfulwebservices;

public class HelloWorldBean {
	String message;
	public HelloWorldBean(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + ", toString()=" + super.toString() + "]";
	}

	
}