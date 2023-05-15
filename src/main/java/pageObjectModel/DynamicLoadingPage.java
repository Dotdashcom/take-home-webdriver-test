package pageObjectModel;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {
	private WebDriver driver;

	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.LINK_TEXT, using ="Example 1: Element on page that is hidden")
	private WebElement loginLink;
	
	
	@FindBy(how = How.XPATH, using = "//button[text()='Start']")
	private WebElement startButton;
	
	@FindBy(how = How.XPATH, using ="//div[@id='finish']/h4")
	private WebElement finishField;

	public String finishText() {
		loginLink.click();
		startButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(finishField));
		String text = finishField.getText();
		return text;
	}
}
