package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FloatingMenu {

	WebDriver driver;
	public FloatingMenu(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(id="menu")
	WebElement fmenu;
	
	  public void scrollDownAndAssertMenuIsDisplayed(){
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		  Assert.assertTrue(fmenu.isDisplayed());
	    }
	
}
