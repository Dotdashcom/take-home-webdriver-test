package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends TestBase {

	public ContextMenuPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "hot-spot")
	private WebElement contextBox;
	
	public void rightClickContextBox() {
		Actions actions = new Actions(driver);
		actions.contextClick(contextBox).build().perform();
	
		
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		
		assertEquals("You selected a context menu",alertMessage);
	}
}
