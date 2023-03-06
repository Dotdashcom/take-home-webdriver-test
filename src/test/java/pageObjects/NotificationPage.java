package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotificationPage extends BaseTemplate{

	public NotificationPage(WebDriver driver) {
		super(driver);
	}
	
	private final By clickHereButton = By.cssSelector("div[class='example'] p a");
	private final By message = By.cssSelector("div[id='flash']");
	ArrayList<String> messages = new ArrayList<String>();
	
	//This method clicks the button and stores the result in the list
	public void clickButtonOnce() {
		wait.until(ExpectedConditions.elementToBeClickable(clickHereButton));
		driver.findElement(clickHereButton).click();
				
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message));
		messages.add(driver.findElement(message).getText());
				
	}
	
	//This method iterates the list and returns true if the output matches expectations
	public boolean isMessageReturnedForClicks(int timesToBeClicked) {
		
		boolean resultFlag = true;
		while(timesToBeClicked>0)
		{
			clickButtonOnce();
			timesToBeClicked--;
		}
		clickButtonOnce();
		for(String s: messages) {
			if(!(s.contains("Action successful") || s.contains("Action unsuccesful, please try again")))
			{
				resultFlag = false;
			}
		}
		return resultFlag;
		
	}
	
}
