package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseTest;

public class CheckBox extends BaseTest {
	
	public CheckBox() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//*[@id='checkboxes']/input[1]")
	private static WebElement UncheckedCheckBox;
	
	@FindBy(xpath="//*[@id='checkboxes']/input[2]")
	private static WebElement CheckedCheckBox;
	
	public void UncheckedCheckBox() {
		UncheckedCheckBox.click();
	}
	
	public void CheckedCheckBox() {
		CheckedCheckBox.click();
	}
	
	public boolean AssertionCheckBox() {
		
		if(UncheckedCheckBox.isSelected()== false) {
			return true;
		}
		else if(CheckedCheckBox.isSelected() == true) {
		    return true;
		}
		return false;
		}

}