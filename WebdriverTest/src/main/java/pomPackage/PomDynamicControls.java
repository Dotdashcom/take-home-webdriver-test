package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseClass;

public class PomDynamicControls extends BaseClass{
	
	
	public PomDynamicControls() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath ="//button[contains(text(),'Remove')]") WebElement removebutton;
	
	@FindBy(id="message") WebElement messageafterremovebutton;
	
	@FindBy(id = "checkbox") WebElement checkbox;
	
	@FindBy (xpath="//*[@id=\"input-example\"]/button") WebElement enablebutton;
	
	@FindBy (xpath = "//*[@id=\"message\"]") WebElement clickenablebuttontext;
	
	public String varifycheckbox() {
		
		removebutton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(messageafterremovebutton));
		
		String message= messageafterremovebutton.getText();
		System.out.println(message);
		return message;
		
	}
	
	public String varifyenableButton() {
		
		enablebutton.click();
		
       WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(clickenablebuttontext));
		
		String message2 = clickenablebuttontext.getText();
		
		return message2;
		
		
	}
	
        public String varifydisableButton()  {
		
		enablebutton.click();
		
		
		
       WebDriverWait wait = new WebDriverWait(driver, 20);
       
		
		wait.until(ExpectedConditions.visibilityOf(clickenablebuttontext));
		
		enablebutton.click();
		
		wait.until(ExpectedConditions.visibilityOf(clickenablebuttontext));
		
		
		
		
		String message2 = clickenablebuttontext.getText();
		
		return message2;
		
		
	}

}
