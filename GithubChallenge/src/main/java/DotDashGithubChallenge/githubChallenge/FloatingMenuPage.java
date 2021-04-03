package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends TestBase{

	public FloatingMenuPage(WebDriver driver) {
		super(driver);
			}
	
	@FindBy(id = "menu")
	private WebElement menu;
	
	public void verifyFloatingMenu() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("http://localhost:7080/floating_menu");
		js.executeScript("window.scrollBy(0,1000)");
		
		assertEquals(true, menu.isDisplayed());
		
	}

}
