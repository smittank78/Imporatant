package com.storage.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/ip")
public class IpController 
{
	@Value("${name}")
	String name;
	@PostConstruct
	public void name() 
	{
		System.out.println("name : " + name );
	}	
	
	@GetMapping("/get")
	public String getSession(HttpServletRequest request,HttpServletResponse response) 
	{
		System.out.println(request.toString());
		return request.getRemoteAddr();
	}
}