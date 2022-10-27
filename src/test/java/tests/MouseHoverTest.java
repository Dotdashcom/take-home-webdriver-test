package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObjects.checkboxPage;
import pageObjects.mouseHoversPage;
import utils.Baseclass;

public class MouseHoverTest {

	Baseclass bs;
	mouseHoversPage mhp;
	@BeforeClass
	public void prereqsteps()
	{
		bs = new Baseclass();
		bs.generateExecutionId();
		bs.createResultsLocation();
	}
	@BeforeMethod
	public void launchAPP() 
	{
		bs.launchApplication("/hovers");
		mhp = new mouseHoversPage(bs);
	}

	/*
	 * Verify mouse hover text for user1
	 */
	@Test
	public void verifymousehovertextuser1() 
	{
		mhp.hoverOnUser1();
		Assert.assertEquals(mhp.getHoverTextUser1(), "name: user1");
	}
	
	/*
	 * Verify mouse hover text for user2
	 */
	@Test
	public void verifymousehovertextuser2() 
	{
		mhp.hoverOnUser2();
		Assert.assertEquals(mhp.getHoverTextUser2(), "name: user2");
	}
	
	/*
	 * Verify mouse hover text for user3
	 */
	@Test
	public void verifymousehovertextuser3() 
	{
		mhp.hoverOnUser3();
		Assert.assertEquals(mhp.getHoverTextUser3(), "name: user3");
	}

	@AfterMethod
	public void endTestExeution() 
	{
		bs.endTestExecution();
	}

}
