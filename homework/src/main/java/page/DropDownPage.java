package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownPage {

	WebDriver driver;

	public DropDownPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Dropdown')]")
	WebElement DROPDOWN_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='dropdown']")
	WebElement DROPDOWN_ELEMENT;

	public void dropDownMenu() {

		DROPDOWN_MENU_ELEMENT.click();

	}

	public void dropDown() throws InterruptedException {

		Select sel = new Select(DROPDOWN_ELEMENT);
		sel.selectByValue("1");
		Thread.sleep(1000);
		sel.selectByValue("2");

		List actualDropdownValues = new ArrayList();

		for (WebElement element : sel.getOptions()) {
			actualDropdownValues.add(element.getText());
		}

		List expectedDropdownValues = new ArrayList();
		expectedDropdownValues.add("Please select an option");
		expectedDropdownValues.add("Option 1");
		expectedDropdownValues.add("Option 2");

		for (int i = 0; i < actualDropdownValues.size(); i++) {
			System.out.println("Actual: " + actualDropdownValues.get(i));
			System.out.println("Actual: " + expectedDropdownValues.get(i));
			Assert.assertTrue(actualDropdownValues.get(i).equals(expectedDropdownValues.get(i)));
		}
	}

}
