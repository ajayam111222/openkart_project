package com.openkart.Baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.openkart.Utility.Reading_properties;



public class Basepage {
	public  Reading_properties R;
	public static WebDriver driver;
	
	public Logger log;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br)
	{
		log = Logger.getLogger("openkart application ");
		PropertyConfigurator.configure("log4j.properties");
		R=new Reading_properties();
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",R.GetchromeBrowser());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",R.GetfirefoxBrowser());
			driver=new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",R.GetEdegeBrowser());
			driver=new EdgeDriver();
		}
		driver.get(R.GetapplicationURL());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
		
	public void captureScreen(WebDriver driver, String screenshot) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\Ajay AM\\git\\NopEcommerce1\\NopEcommerce\\Screenshots\\"+screenshot+"-"+".jpg");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	
	}
	public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	
	

}
