package TheInternet.TheInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControls extends Base {
	
	
	@FindBy(xpath="//button[text()='Remove']")
	WebElement removeButton;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement addButton;
	
	@FindBy(xpath="//button[contains(@onclick,'swapCheckbox')]")
	WebElement swapCheckboxButton;
	
	@FindBy(xpath="//button[contains(@onclick,'swapInput')]")
	WebElement swapInputButton;
	
	@FindBy(xpath="//button[text()='Enable']")
	WebElement enableButton;
	
	@FindBy(xpath="//button[text()='Disable']")
	WebElement disableButton;
	
	@FindBy(xpath="//input/parent::div[contains(text(),'checkbox')]")
	WebElement dynamicControlsCheckbox;
	                
	@FindBy(xpath="//form[@id='input-example']/input")
	WebElement dynamicControlsBar;
	
	
	
	public void browserInitialization() {
		driverInitialization();
		PageFactory.initElements(driver, this);
		
	}
	
	

}
