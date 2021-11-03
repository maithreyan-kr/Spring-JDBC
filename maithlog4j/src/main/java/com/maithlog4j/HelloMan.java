package com.maithlog4j;

import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;

public class HelloMan {
	private static final org.apache.log4j.Logger logger = LogManager.getLogger(HelloMan.class);
	public static void main(String[] args) {
		
	
		// basic log4j configurator
		BasicConfigurator.configure();
		logger.info("Hello Employee");
		logger.info("we are in logger info mode");

		}


	}


