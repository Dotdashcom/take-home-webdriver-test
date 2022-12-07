package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import Common.Config;
public class ContextMenuPage extends BasePage {
	@FindBy (id = "hot-spot")
	WebElement hotSpot;
	public ContextMenuPage (Config testConfig) {
		super(testConfig);
	}
	public void clickHotSpot() {
		(new Actions(testConfig.driver)).contextClick(hotSpot).perform();
	}
	public String getAlertText() {
		return testConfig.driver.switchTo().alert().getText();
	}
}
