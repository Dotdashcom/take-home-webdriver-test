package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import Common.Config;
public class DropdownPage extends BasePage {
	@FindBy (id = "dropdown")
	WebElement dropdown;
	public DropdownPage (Config testConfig) {
		super(testConfig);
	}
	public String getSelectedOption() {
		return (new Select(dropdown)).getFirstSelectedOption().getText();
	}
	public void selectOption(String option) {
		(new Select(dropdown)).selectByVisibleText(option);
	}
}
