package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage extends BaseClass {
	public CheckBoxPage(){
		PageFactory.initElements(driver, this);
	}
	
 @FindBy(xpath="//*[@id='checkboxes']/input[1]")
 private WebElement clickCheckBox1;

@FindBy(xpath="//*[@id='checkboxes']/input[2]")
private WebElement clickCheckBox2;

public void selectCheckBox1() {
	clickCheckBox1.click();
}

public void deselectCheckBox2() {
	clickCheckBox2.click();
}

public boolean  validateCheckBox1() {
	return clickCheckBox1.isSelected();
}

public boolean  validateCheckBox2() {
	return clickCheckBox2.isSelected();
}
}


