package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckBoxesPage {
	
private WebDriver driver;
	
	public CheckBoxesPage(WebDriver driver) {		
		this.driver = driver;
	}
	
	By checkBoxes = By.cssSelector("#checkboxes input");
	
	public void CheckCheckbox(String checkboxNumber) {
		List <WebElement> elements = driver.findElements(checkBoxes);	
			
			switch (checkboxNumber) {
			case  "CheckBox 1":
				elements.get(0).click();
				break;
				
			case  "CheckBox 2":
				elements.get(1).click();
				break;
				
			default:
				throw new IllegalArgumentException("Invalid Option");
			}	
	}
	
			public Boolean VerifyIfCheckCheckboxIsChecked(String checkboxNumber) {
				
				List <WebElement> elements = driver.findElements(checkBoxes);	
				boolean value = false;	
				
					switch (checkboxNumber) {
					case  "CheckBox 1":
						try {
							if (elements.get(0).isSelected()) {
								value =true;
							};
						}catch(Exception e) {
							value = false;
						}
						
						break;
						
					case  "CheckBox 2":
						try {
							if (elements.get(1).isSelected()) {
								value =true;
							};
						}catch(Exception e) {
							value = false;
						}
						break;
						
					default:
						throw new IllegalArgumentException("Invalid Option");
					}	
	            return value;
			
			}
			
			public void CheckBoxFirstIsSelected() {
				Assert.assertTrue(VerifyIfCheckCheckboxIsChecked("CheckBox 1"));
			}
			
			public void CheckBoxSecondIsSelected() {
				Assert.assertTrue(VerifyIfCheckCheckboxIsChecked("CheckBox 2"));
			}
			
			public void CheckBoxFirstIsUnchecked() {
				Assert.assertFalse(VerifyIfCheckCheckboxIsChecked("CheckBox 1"));
			}
			
			public void CheckBoxSecondIsUnchecked() {
				Assert.assertFalse(VerifyIfCheckCheckboxIsChecked("CheckBox 2"));
			}

}
