package PageObjects;
import org.openqa.selenium.support.PageFactory;
import Common.Config;
import Common.Logger;
public class BasePage {
	Config testConfig;
	BasePage (Config testConfig) {
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Logger.Log(this.getClass() + " is being loaded");
	}
}
