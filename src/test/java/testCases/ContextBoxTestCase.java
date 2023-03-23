package testCases;

import org.testng.Assert;
import org.testng.annotations.*;


import pages.BaseClass;
import pages.ContextMenuPage;


public class ContextBoxTestCase extends BaseClass {
	public ContextMenuPage contextMenuPage;
	public ContextBoxTestCase(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		System.out.println("Before Method");
		initialization("urlContext");
		contextMenuPage = new ContextMenuPage();	
	}
	
	@Test
	public void contextTestCase() throws Exception {
		System.out.println("in test case class");
		String alertText = contextMenuPage.rightClickOnContextBox();
		System.out.println("The alert text is: "+alertText);
		Assert.assertEquals(alertText, "You selected a context menu");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("driver in tear down method");
		driver.close();
	}
}
