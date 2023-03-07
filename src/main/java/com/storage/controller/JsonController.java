package com.storage.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.storage.dto.Person;

@RestController
@RequestMapping("/json")
public class JsonController 
{
	@GetMapping("/key-value")
	public Person person(@RequestBody Person person) 
	{
		person.setDate(new Date());
		person.setShowOnly("written by controller not by postman");
		return person;
	}
}