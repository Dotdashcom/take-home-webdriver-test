package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MousOverPage extends TestBase{

	public MousOverPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//div[@class='figure']")
	private List<WebElement> users;
	
	public void verifyUsers() throws InterruptedException {
		
		for(int i = 0; i < users.size(); i++) {
			Actions actions = new Actions(driver);
			actions.moveToElement(users.get(i)).perform();
			WebElement img = users.get(i).findElement(By.tagName("img"));
			WebElement name = users.get(i).findElement(By.xpath("./div/h5"));

			assertEquals(true,img.isDisplayed());
			assertEquals(true,name.isDisplayed());
			Thread.sleep(5000);
		}
				
	}

	

}
