package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JavascriptAlertsPage extends BaseTemplate{

	public JavascriptAlertsPage(WebDriver driver) {
		super(driver);
	}

	private final By jsAlertButton = By.cssSelector("button[onclick='jsAlert()']");
    private final By jsConfirmButton = By.cssSelector("button[onclick='jsConfirm()']");
    private final By jsPromptButton = By.cssSelector("button[onclick='jsPrompt()']");
    private final By resultText = By.cssSelector("#result");
    
    public void clickJsAlertButton() {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jsAlertButton));
    	driver.findElement(jsAlertButton).click();
    }
    
    public void clickJsConfirmButton() {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jsConfirmButton));
    	driver.findElement(jsConfirmButton).click();
    }
    
    public void clickJsPromptButton() {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jsPromptButton));
    	driver.findElement(jsPromptButton).click();
    }
	
    public String getResultMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(resultText));
        return driver.findElement(resultText).getText();
        
    }
    
    public String getJsMessage() {
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return message;
    }
    
    public void SendMessagejsPrompt(String message) {
        driver.switchTo().alert().sendKeys(message);
        driver.switchTo().alert().accept();
    }

}
