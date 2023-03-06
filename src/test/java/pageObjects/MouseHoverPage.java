package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverPage extends BaseTemplate{

	public MouseHoverPage(WebDriver driver) {
		super(driver);
	}

	private final By images = By.cssSelector("div[class='figure']");
	private final By details = By.cssSelector("div[class='figcaption']");


	public boolean isInfoDisplayed() {

		Actions hover = new Actions(driver);
		List<WebElement> users = driver.findElements(images);
		List<WebElement> info = driver.findElements(details);
		boolean response=true;
		for(int i =0; i<users.size(); i++)
		{
			
			hover.moveToElement(users.get(i)).perform();
			if(!info.get(i).isDisplayed())
			{
				response=false;
			}
		}
		return response;
	}


}
