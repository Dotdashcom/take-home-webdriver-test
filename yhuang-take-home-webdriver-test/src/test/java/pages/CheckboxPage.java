package pages;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CheckboxPage extends BaseDriver{
	public CheckboxPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="form#checkboxes input")
	public List<WebElement> checkboxes;
	
	public boolean isCheckboxChecked(int index) {
		return checkboxes.get(index).isSelected();
	}
	
	public void clickCheckbox(int index) {
		checkboxes.get(index).click();
	}
	
	public int getNumberOfCheckboxes() {
		return checkboxes.size();
	}
}
