package dotdash.pageobjects;

import java.io.FileNotFoundException;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

public WebDriver driver;
	
	

	@FindBy(id="dropdown")
	private WebElement dropdown;
	
	
	public DropdownPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void selectOption(String text)  {
		Select dd = new Select(dropdown);
		dd.selectByVisibleText(text);
		Assert.assertEquals(dd.getFirstSelectedOption().getText(), text);
	}
	

}
