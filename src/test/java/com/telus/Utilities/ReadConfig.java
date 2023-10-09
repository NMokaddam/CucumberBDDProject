package com.telus.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	
	String path= "config.properties";
	
	//constructor
	public ReadConfig() throws Exception
	{
		properties = new Properties();
		
		//to open config .properties file in input mode and load the file
		FileInputStream fis = new FileInputStream(path);
		properties.load(fis);
	}
	
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file");
	}
}
