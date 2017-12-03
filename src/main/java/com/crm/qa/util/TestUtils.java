package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtils extends TestBase{
	
	
	public  void switchToFrame(String name){
		
		driver.switchTo().frame(name);
		
	}
	
	

}
