package com.openkart.Utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class Reading_properties {
	 Properties pro;
	
	public Reading_properties() 
	{
		
		File file=new File(".\\Configuration\\config.properties");
		try {
		FileInputStream input=new FileInputStream(file);
		
         pro=new Properties();
         pro.load(input);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public String GetapplicationURL()
	{
		String URL=pro.getProperty("url");
		return URL;
	}
	
	public String GetchromeBrowser()
	{
		String CHROME=pro.getProperty("chrome1");
		return CHROME;
	}
	
	public String GetfirefoxBrowser()
	{
		String FIREFOX=pro.getProperty("firefox");
		return FIREFOX;
	}
	
	public String GetEdegeBrowser()
	{
		String EDGE=pro.getProperty("edge1");
		return EDGE;
	}
	public String Getusername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	public String Getpassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	
	
	
	
	

}
