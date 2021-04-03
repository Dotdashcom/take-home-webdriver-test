package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage extends TestBase {

	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
			}

	@FindBy(xpath = "//button[text()='Start']")
	private WebElement startBtn;
	
	@FindBy(id = "finish")
	private WebElement finishMessage;
	
	
	
	public void verifyDynamicLoad() throws InterruptedException {
	
		System.out.println(startBtn.getText());
		WebDriverWait wait = new WebDriverWait(driver, 20);
		startBtn.click();

		wait.until(ExpectedConditions.visibilityOf(finishMessage));
		System.out.println(finishMessage.getText());
		assertEquals("Hello World!", finishMessage.getText());
		Thread.sleep(5000);
	}
}
