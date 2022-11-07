package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import PageObjects.CheckBoxPage;
import PageObjects.ContextMenuPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class ContextClickTest extends InternetWebBaseTest{
	
	@Test()
	public void testcontextclick() throws IOException, InterruptedException {
	driver.get(loadProperties().getProperty("BASE_URL")+"context_menu");
	driver.manage().window().maximize();
    Thread.sleep(2000);
	ContextMenuPage contextmenu=new ContextMenuPage(driver);
	WebElement element=contextmenu.searchContextbox();
	Actions action=new Actions(driver);
	Thread.sleep(2000);
	action.contextClick(element).perform();
	Assert.assertEquals("PopUp window is not working",driver.switchTo().alert().getText(),"You selected a context menu");
	driver.switchTo().alert().accept();
    Assert.assertEquals("alert accept is not working",driver.getTitle(),"The Internet");
	}
}
