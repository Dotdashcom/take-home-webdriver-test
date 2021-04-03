package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframePage extends TestBase {

	public IframePage(WebDriver driver) {
		super(driver);
			}

	@FindBy(id = "tinymce")
	private WebElement mce;
	
	public void switchIframe() throws InterruptedException {
		
		driver.manage().window().maximize();

		driver.switchTo().frame("mce_0_ifr");
		
		WebElement mce = driver.findElement(By.id("tinymce"));
		mce.clear();
		mce.sendKeys("Testing iframe");
		
	
		//Thread.sleep(5000);
		assertEquals("Testing iframe", mce.getText());
	}
}
