package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseClass;

public class PomDynamicLoading extends BaseClass {
	
	public PomDynamicLoading() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@id='start' ]//button[contains(text(),'Start')]") WebElement startbutton;
	
	@FindBy (xpath ="//div[@id='finish' ]//h4[contains(text(),'Hello World')]") WebElement afterclickmessage;
	
	
	public String clickonstartbutton() throws InterruptedException {
		
		startbutton.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(afterclickmessage));
		
		String message = afterclickmessage.getText();
		System.out.println(message);
		return message;
		
	}
	

}
