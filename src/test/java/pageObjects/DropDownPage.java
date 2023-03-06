package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BaseTemplate{

	public DropDownPage(WebDriver driver) {
		super(driver);
	}
	
	 private final By dropDown = By.cssSelector("select[id='dropdown']");

	 public void clickDropDown() {
		 wait.until(ExpectedConditions.elementToBeClickable(dropDown));
		 driver.findElement(dropDown).click();
	 }
	 
	 public String fetchSelectedOption(String option) {
		 Select select = new Select(driver.findElement(dropDown));
		 select.selectByVisibleText(option);
		
		 return select.getFirstSelectedOption().getText();
	 }
	
}
