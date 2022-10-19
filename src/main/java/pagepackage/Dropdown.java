package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basepackage.BaseTest;

public class Dropdown extends BaseTest {

	public Dropdown() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dropdown")
	private static WebElement dropdownmenu;
	
	@FindBy(xpath="//*[@id='dropdown']/option[2]")
	private static WebElement option1;
	
	@FindBy(xpath="//*[@id='dropdown']/option[3]")
	private static WebElement option2;
	
	public void Dropdownoption1(){
		select = new Select(dropdownmenu);
		select.selectByValue("1");
		dropdownmenu.getText().toString();
	}
	
	public void Dropdownoption2(){
		select = new Select(dropdownmenu);
		select.selectByValue("2");
		dropdownmenu.getText().toString();
	}
	
	public void DropdownAssertion() {
		new Dropdown();
		if(option1.isSelected()) {
			Assert.assertEquals(option1.isDisplayed(), true);
		}
		else if (option2.isSelected()) {
			Assert.assertEquals(option2.isDisplayed(),true);
		}
	}
}