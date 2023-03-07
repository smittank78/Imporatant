package com.storage.service;

import java.util.Date;
import java.util.logging.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Service 
{
	Logger logger = Logger.getLogger(Service.class.getName());
	/*
	 * Scheduled Method
	 */
	@Scheduled(initialDelay = 3000,fixedDelay = 20000)
	public void scheduleMsg()
	{
		logger.info("method executed on scheduled time : " + new Date(System.currentTimeMillis()));
	}
}