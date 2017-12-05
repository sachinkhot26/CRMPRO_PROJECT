package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	
	public void setUp(){
		
		initialization();
		
	    loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	
	public void loginPageTitleTest(){
		
		String title = loginPage.validateLoginPageTitle();
		AssertJUnit.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	
	public void crmLogoImageTest(){
		
		boolean flag = loginPage.validateCrmLogo();
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(priority=3)
	
	public void loginTest() throws Exception{
		
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
	
	
	@AfterMethod
	
	public void tearDown(){
		driver.quit();
	}
}
