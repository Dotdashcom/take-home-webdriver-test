package navpreet.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxesPageObject {

	WebDriver driver;

	public CheckBoxesPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href='/checkboxes']")
	private WebElement checkbox;

	@FindBy(css = "input[type='checkbox']")
	private List<WebElement> tick_checkboxes;

	public void ClickCheckbox() {
		checkbox.click();
	}

	public void ChooseCheckboxes() {
		for (int i = 0; i < tick_checkboxes.size(); i++) {

			if (!tick_checkboxes.get(i).isSelected()) {
				tick_checkboxes.get(i).click();
			}
		}

	}

}
