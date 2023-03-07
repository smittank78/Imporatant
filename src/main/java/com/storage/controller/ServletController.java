package com.storage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/servlet")
public class ServletController 
{
	@RouterOperation(
					 path = "/servlet/set/cookie",
					 beanClass = ServletController.class,
					 beanMethod = "Create-Cookie",
					 method = RequestMethod.GET,
					 consumes = "HttpServletResponse",
					 produces = {MediaType.TEXT_PLAIN_VALUE},
					 operation = @Operation(
							 	operationId = "createCookie",
							 	responses = {
							 			@ApiResponse(
							 					responseCode = "200",
							 					description = "ok... Coockie Created",
							 					content = @Content(
							 							schema = @Schema(
							 									implementation = String.class
							 									)
							 							)							 					
							 					),
							 			@ApiResponse(
							 					responseCode = "404",
							 					description = "Not Found",
							 					content = @Content(
							 							schema = @Schema(
							 									implementation = String.class
							 									)
							 							)							 					
							 					)
							 	},
							 	parameters = {
							 			@Parameter(in = ParameterIn.PATH,name = "")
							 	}
							 )
			)
	@GetMapping("/set/cookie")
	public String createCookie(HttpServletResponse response) 
	{
		Cookie cookie = new Cookie("user", "smit");
		Cookie cookie1 = new Cookie("user1", "smit");
		Cookie cookie2 = new Cookie("user2", "smit");
		
		cookie1.setAttribute("city", "rajkot");
		cookie1.setAttribute("phone", "173");

		cookie2.setAttribute("city", "surat");
		cookie2.setAttribute("phone", "174");

		cookie.setMaxAge(7*24*60*60);
		cookie1.setMaxAge(7*24*60*60);
		cookie2.setMaxAge(7*24*60*60);

		List<Cookie> cookies = Arrays.asList(cookie,cookie1,cookie2);
		
		for (Cookie c : cookies) 
		{
			System.out.println(c.getName() + " - " + c.getValue());
			Map<String,String> cookieAttributes = c.getAttributes();
			System.out.println("attributes : " + cookieAttributes.size());
			for (String key : cookieAttributes.keySet()) {
				System.out.println(key + " : " + cookieAttributes.get(key));
			}
		}
		
		cookies.forEach(c -> response.addCookie(c));
		
		return "cookie created...";
	}
	
	@GetMapping("/set/session")
	public String setSession(HttpServletRequest request,HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		session.setAttribute("user", "mit");
		//session.invalidate();
		
		return "session created...";
	}
	@GetMapping("/get/session")
	public String getSession(HttpServletRequest request,HttpServletResponse response) 
	{
		return "session received..." + request.getSession().getAttribute("user");
	}
	@GetMapping("/get/cookie")
	public String createCookie1(HttpServletRequest request) 
	{
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " - " + cookie.getValue());
		}
		return "ok";
	}
}