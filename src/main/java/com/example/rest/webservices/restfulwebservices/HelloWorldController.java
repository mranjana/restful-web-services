package com.example.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//Controller
@RestController
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource;
	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	//hello-world-bean
	@RequestMapping(method=RequestMethod.GET,path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	@RequestMapping(method=RequestMethod.GET,path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World %s",name));
	}
	@RequestMapping(method=RequestMethod.GET,path="/hello-world-international")
	public String helloWorldIntern(@RequestHeader(name="Accept-Language",required = false)Locale locale){
		return messageSource.getMessage("good.morning.message",null,locale);
	}
}
