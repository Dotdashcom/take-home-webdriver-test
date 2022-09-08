package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DropdownPage {
	static WebDriver driver;

	public DropdownPage(WebDriver driver) {
		DropdownPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//select[@id = 'dropdown']")
	WebElement DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//option[@value = '1']")
	WebElement OPTION_1_ELEMENT;
	@FindBy(how = How.XPATH, using = "//option[@value = '2']")
	WebElement OPTION_2_ELEMENT;

//	Methods
	public void clickOnDropdown() {
		DROPDOWN_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectOption1() {
		Select sel = new Select(DROPDOWN_ELEMENT);
		sel.selectByVisibleText("Option 1");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectOption2() {
		Select sel = new Select(DROPDOWN_ELEMENT);
		sel.selectByVisibleText("Option 2");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateOption1IsSelected() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(OPTION_1_ELEMENT));
		Assert.assertTrue(element.isSelected(), "Selected wrong option or option 1 is not selected!!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Selected wrong option!!!");
		}
	}

	public void validateOption2IsSelected() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(OPTION_2_ELEMENT));
		Assert.assertTrue(element.isSelected(), "Selected wrong option or option 2 is not selected!!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
