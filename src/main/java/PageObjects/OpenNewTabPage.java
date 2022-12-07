package PageObjects;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Common.Config;
public class OpenNewTabPage extends BasePage {
	@FindBy (css = "#content > div > a")
	WebElement clickHereLink;
	@FindBy (css = "body > div > h3")
	WebElement newWindowText;
	public OpenNewTabPage (Config testConfig) {
		super(testConfig);
	}
	public void clickToOpenNewTabAndSwitch() {
		clickHereLink.click();
		Set <String> allWindows = testConfig.driver.getWindowHandles();
		String currentWindow = testConfig.driver.getWindowHandle();
		for (String window : allWindows) {
			if (!window.equals(currentWindow)) {
				testConfig.driver.switchTo().window(window);
			}
		}
		PageFactory.initElements(testConfig.driver, this);
	}
	public String getTextFromNewTab() {
		return newWindowText.getText();
	}
}
