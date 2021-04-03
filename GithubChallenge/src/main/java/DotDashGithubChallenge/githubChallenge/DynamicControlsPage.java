package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage extends TestBase{
public DynamicControlsPage(WebDriver driver) {
	super(driver);
}
@FindBy(xpath = "//button[@onclick='swapCheckbox()']")
private WebElement removeBtn;

@FindBy(id = "message")
private WebElement Message;

@FindBy(xpath = "//button[@onclick='swapInput()']")
private WebElement enableBtn;


WebDriverWait wait = new WebDriverWait(driver, 20);

public void verifyRemoveBtn() throws InterruptedException {
	removeBtn.click();
	wait.until(ExpectedConditions.visibilityOf(Message));
	assertEquals("It's gone!", Message.getText());
	Thread.sleep(3000);
}

public void addAndVerifyMessageIsVisible() throws InterruptedException {
	removeBtn.click();
	//wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(Message));
	assertEquals("It's back!", Message.getText());
	//Thread.sleep(3000);
}

public void enableTextboxAndVerifyMessageIsVisible() {
	enableBtn.click();
//	wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(Message));
	assertEquals("It's enabled!", Message.getText());
}

public void disableTextboxAndVerifyMessageIsNotThere() {
	enableBtn.click();
	wait.until(ExpectedConditions.visibilityOf(Message));
	assertEquals("It's disabled!", Message.getText());
}
}
