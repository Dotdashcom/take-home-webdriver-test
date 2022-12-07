package PageObjects;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Common.Config;
public class FloatingMenuPage extends BasePage {
	@FindBy (css = "#menu > ul > li:nth-child(1) > a")
	List <WebElement> menuTabs;
	public FloatingMenuPage (Config testConfig) {
		super(testConfig);
	}
	public void scrollDown() {
		((JavascriptExecutor) testConfig.driver).executeScript("window.scroll(0,1000)");
	}
	public boolean isMenuDisplayed() {
		boolean isMenuDisplayed = true;
		for (WebElement menuTab : menuTabs) {
			isMenuDisplayed = isMenuDisplayed && menuTab.isDisplayed();
		}
		return isMenuDisplayed;
	}
}
