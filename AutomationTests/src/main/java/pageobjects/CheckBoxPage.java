package pageobjects;

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
	
	@FindBy(xpath="//form[@id='checkboxes']/input[1]")
	 WebElement checkbox1;


	@FindBy(xpath="//form[@id='checkboxes']/input[2]")
	 WebElement checkbox2;


	public WebElement getCheckbox1() {
		return checkbox1;
	}

	public WebElement getCheckbox2() {
		return checkbox2;
	}

	public void selectCheckbox1() {
			checkbox1.click();
	}
	public void selectCheckbox2() {
			checkbox2.click();
		}
		
	}


