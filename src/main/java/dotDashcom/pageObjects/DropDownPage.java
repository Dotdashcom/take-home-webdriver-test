package dotDashcom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
	WebDriver driver;

	public DropDownPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="dropdown")
	private WebElement dropdown;
	
	public void selectOption1() {
		Select option = new Select(dropdown);
		option.selectByVisibleText("Option 1");
	}
	public void selectOption2() {
		Select option = new Select(dropdown);
		option.selectByVisibleText("Option 2");
	}
	
	public String isOptionSelected() {
		Select option = new Select(dropdown);
		String selectedOption=option.getFirstSelectedOption().getText();
		System.out.println(selectedOption);
		return selectedOption;
	}
	

}
