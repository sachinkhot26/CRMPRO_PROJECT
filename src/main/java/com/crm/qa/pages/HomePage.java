package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//ContactsPage contactPage;
	
	
	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactPageLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsPageLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement taskPageLink;
	
	
	public HomePage(){
		
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean validateUsername(){
		
		return usernameLabel.isDisplayed();
	}
	
	public String verifyPageTitle(){
		
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts(){
		
		contactPageLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals(){
		
		dealsPageLink.click();
		return new DealsPage();
		
	}
	
	public TasksPage clickOnTasks(){
		
		taskPageLink.click();
		return new TasksPage();
	}
	
	

	
	
	
	
	
	
	
	
	
	

}
