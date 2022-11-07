package tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.DragandDropPage;
import PageObjects.LoginPage;
import Utility.InternetWebBaseTest;

public class DragandDrpoTest extends InternetWebBaseTest{
	@Test()
	public void testdraganddrop() throws IOException {
		driver.get(loadProperties().getProperty("BASE_URL")+"drag_and_drop");
		DragandDropPage draganddroppage=new DragandDropPage(driver);
		WebElement elementA=draganddroppage.searchdraganddropa();
		WebElement elementB=draganddroppage.searchdraganddropb();
		Actions action=new Actions(driver);
		action.clickAndHold(elementA).moveToElement(elementB).release(elementB).build().perform();	
		System.out.println(elementA.getText());
		Assert.assertTrue(elementA.getText().equals("A"));
	}

}
