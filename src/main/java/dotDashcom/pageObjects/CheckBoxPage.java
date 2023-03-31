package dotDashcom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckBoxPage {

	WebDriver driver;

	public CheckBoxPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected())

	@FindBy(xpath = "//input[@type='checkbox'][1]")
	private WebElement checkBox1;

	@FindBy(xpath = "//input[@type='checkbox'][2]")
	private WebElement checkBox2;

	
	public WebElement getCheckBox1() {
		return checkBox1;
	}
	public WebElement getCheckBox2() {
		return checkBox2;
	}
}
