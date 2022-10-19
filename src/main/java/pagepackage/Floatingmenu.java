package pagepackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseTest;

public class Floatingmenu extends BaseTest {
public Floatingmenu() {
	PageFactory.initElements(driver, this);
}

@FindBy(id = "menu")
private static WebElement menu;

@FindBy(xpath="//*[@id=\"menu\"]/ul/li[1]/a")
private static WebElement home;

public void floatingmenu() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	
	Assert.assertEquals(home.isEnabled(),true);
	

	

}
	
}