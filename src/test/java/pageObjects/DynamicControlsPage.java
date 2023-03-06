package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicControlsPage extends BaseTemplate{

	public DynamicControlsPage(WebDriver driver) {
		super(driver);
	}
	
	private final By checkBox = By.xpath("//input[@id='checkbox']");
	private final By textBox = By.xpath("//input[@type='text']");
    private final By message = By.cssSelector("p[id='message']");
    private final By removeAddButton = By.cssSelector("button[onclick='swapCheckbox()']");
    private final By enableDisableButton = By.cssSelector("button[onclick='swapInput()']");

    public void clickAddRemoveButton() {
    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(removeAddButton));
    	driver.findElement(removeAddButton).click();
    }
    
    public void clickEnableDisableButton() {
    	wait.until(ExpectedConditions.elementToBeClickable(enableDisableButton));
    	driver.findElement(enableDisableButton).click();
    }
    
    public boolean isTextBoxEnabled() {
    	wait.until(ExpectedConditions.elementToBeClickable(enableDisableButton));
    	return driver.findElement(textBox).isEnabled();
    }
    
    public String returnMessageDisplayed() {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message));
    	return driver.findElement(message).getText();
    }
    
    
}
