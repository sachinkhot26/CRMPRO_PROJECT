package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		
		try{
			prop=new Properties();
			FileInputStream fis = new FileInputStream("/Users/sachinkhot/Desktop/Eclipse/CRMPRO/src/main/java/com/crm/qa/config/config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","/Users/sachinkhot/Desktop/selenium/chromedriver");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("ff")){
			
			System.setProperty("webdriver.gecko.driver","/Users/sachinkhot/Desktop/selenium/geckodriver");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
