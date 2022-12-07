package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Common.Config;
public class IframePage extends BasePage {
	@FindBy (id = "mce_0_ifr")
	WebElement iframe;
	@FindBy (id = "tinymce")
	WebElement textField;
	public IframePage (Config testConfig) {
		super(testConfig);
	}
	public void addText(String text) {
		testConfig.driver.switchTo().frame(iframe);
		textField.clear();
		textField.sendKeys(text);
	}
	public String getAddedTest() {
		return textField.getText();
	}
}
