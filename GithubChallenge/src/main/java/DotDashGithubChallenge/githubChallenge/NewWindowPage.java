package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewWindowPage extends TestBase {

	public NewWindowPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@href ='/windows/new']")
	private WebElement openNewWindow;
	
	public void verifyNewWindowOpen() {
		
		openNewWindow.click();
		String MainWindow = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iter = windowHandles.iterator();

		while(iter.hasNext()) {
			String childhandle = iter.next();
			if (!MainWindow.equals(childhandle)) {
				driver.switchTo().window(childhandle);
			}
		}
		assertEquals("New Window", driver.getTitle());
		WebElement newWindowMessage = driver.findElement(By.tagName("h3"));
		assertEquals("New Window", newWindowMessage.getText().trim());
	}

}
