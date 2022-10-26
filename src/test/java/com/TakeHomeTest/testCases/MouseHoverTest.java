package com.TakeHomeTest.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.MouseHoverPageObjects;

public class MouseHoverTest extends BaseClass{

	@Test
	public void hover() {
		MouseHoverPageObjects hoverpage=new MouseHoverPageObjects(driver);

		driver.get(url+"/hovers");
		
		hoverpage.hoverimage1();
	String returneduser1=hoverpage.user1details();
	Assert.assertEquals(returneduser1, "name: user1");
	
	hoverpage.hoverimage2();
	String returneduser2=hoverpage.user2details();
	Assert.assertEquals(returneduser2, "name: user2");
	
	hoverpage.hoverimage3();
	String returneduser3=hoverpage.user3details();
	Assert.assertEquals(returneduser3, "name: user3");
	}
	
	
	
}
