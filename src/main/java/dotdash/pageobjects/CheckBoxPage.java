package dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {

public WebDriver driver;
	
	

	@FindBy(xpath="//form[@id='checkboxes']/input[1]")
	private WebElement checkbox1;
	
	
	@FindBy(xpath="//form[@id='checkboxes']/input[2]")
	private WebElement checkbox2;
	
	
	public CheckBoxPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getCheckbox1() {
		return checkbox1;
	}

	public WebElement getCheckbox2() {
		return checkbox2;
	}
	
	public void SelectCheckbox(int checkbox) {
		
		if (checkbox == 1) {
			checkbox1.click();
			
		} else {
			checkbox2.click();
		}
	}
	
}
