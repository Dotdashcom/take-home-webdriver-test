package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.TestBase;

public class CheckBoxesPage extends TestBase {
	@FindBy(xpath="//input[@type='checkbox'][1]")
	public static	WebElement checkBox1;
	@FindBy(xpath="//input[@type='checkbox'][2]")
	 public static WebElement checkBox2;

	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void LandingPage() {
		driver.get(BaseUrl+"/checkboxes");
	}
	public void ClickOnCheckBox1() {
		checkBox1.click();	
	}
	public boolean ValidateCheckBox1() {
		return checkBox1.isSelected();
	}
	public void ClickOnCheckBox2() {
		checkBox2.click();
	}
	public boolean ValidateCheckBox2() {
		return checkBox2.isSelected();
	}
	public void closeBrowser() {
		driver.quit();
	}
	
}
