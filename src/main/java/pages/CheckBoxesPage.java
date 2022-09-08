package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckBoxesPage {
	static WebDriver driver;

	public CheckBoxesPage(WebDriver driver) {
		CheckBoxesPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//form[@id = 'checkboxes']//input[1]")
	WebElement CHECKBOX_1_RADIO_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//form[@id = 'checkboxes']//input[2]")
	WebElement CHECKBOX_2_RADIO_BUTTON_ELEMENT;

//	Methods
	public void checkCheckBox1() {
		CHECKBOX_1_RADIO_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void checkCheckBox2() {
		CHECKBOX_2_RADIO_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void uncheckCheckBox1() {
		CHECKBOX_1_RADIO_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void uncheckCheckBox2() {
		CHECKBOX_2_RADIO_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCheckBox1IsChecked() {
		Assert.assertTrue(CHECKBOX_1_RADIO_BUTTON_ELEMENT.isSelected(), "Checkbox 1 is not checked!!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCheckBox1IsUnchecked() {
		try {
			Assert.assertTrue(CHECKBOX_1_RADIO_BUTTON_ELEMENT.isSelected(), "Checkbox 1 is still checked!!!");
		} catch (AssertionError e) {
			System.out.println("Checkbox 1 is unchecked");
		}
	}

	public void validateCheckBox2IsUnChecked() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(CHECKBOX_2_RADIO_BUTTON_ELEMENT));
			Assert.assertTrue(element.isSelected(), "Checkbox 2 is  checked!!!");
		} catch (AssertionError e) {
			System.out.println("Checkbox 2 is unchecked");
		}
	}

	public void validateCheckBox2IsChecked() {
		Assert.assertTrue(CHECKBOX_2_RADIO_BUTTON_ELEMENT.isSelected(), "Checkbox 2 is not checked!!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
