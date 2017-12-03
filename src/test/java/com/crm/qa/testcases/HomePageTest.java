package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtils;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	DealsPage dealPage;
	TasksPage taskPage;
	TestUtils testUtil;
	
	
	public HomePageTest(){
		
		super();
	}
	
	@BeforeMethod
	
	public void setUp() throws Exception{
		
		initialization();
		loginPage = new LoginPage();
		testUtil=new TestUtils();
		//contactPage=new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	
	@Test(priority=1)
	public void verifyHomePageTitle(){
		
		String homePageTitle=homePage.verifyPageTitle();
		
		Assert.assertEquals(homePageTitle, "CRMPRO");
		
	}
	
	@Test(priority=2)
	public void verifyUserNamelabel(){
		testUtil.switchToFrame("mainpanel");
		boolean flag = homePage.validateUsername();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	
	public void verifyContactPage(){
		testUtil.switchToFrame("mainpanel");
		contactPage=homePage.clickOnContacts();
		
		Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'Contacts')]")).isDisplayed());
		
	}
	
	@Test(priority=4)
	public void verifyDealsPage(){
		testUtil.switchToFrame("mainpanel");
		dealPage = homePage.clickOnDeals();
	}

	@Test(priority=5)
	public void verifyTasksPage(){
		testUtil.switchToFrame("mainpanel");
		taskPage = homePage.clickOnTasks();
	}
	
	
	@AfterMethod
	
	public void tearDown(){
		
		driver.quit();
	}
	
	

}
