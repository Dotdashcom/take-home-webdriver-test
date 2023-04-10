package navpreet.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPageObject {

	WebDriver driver;
	Select select;
	String text ;

	public DropDownPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "dropdown")
	private WebElement dropDown;
	
	@FindBy(xpath="//a[text()='Dropdown']")
	private WebElement click_dropDown;

	public void ClickDropDown()
	{
		click_dropDown.click();
	}
	
	public void selectOption1() {
		Select option = new Select(dropDown);
		option.selectByVisibleText("Option 1");
	}
	public void selectOption2() {
		Select option = new Select(dropDown);
		option.selectByVisibleText("Option 2");
}
	
	public String isOptionSelected() {
		Select option = new Select(dropDown);
		String selectedOption=option.getFirstSelectedOption().getText();
		System.out.println(selectedOption);
		return selectedOption;
	}
//	public String DropDown() {
//		select = new Select(dropDown);
//		select.selectByVisibleText("Option 1");
//		String text = dropDown.getText();
//		return text;
//	}

}
