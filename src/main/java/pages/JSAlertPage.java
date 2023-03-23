package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSAlertPage extends BaseClass {
	public JSAlertPage(){
		PageFactory.initElements(driver, this);
	}
 @FindBy(xpath="//*[@id='content']/div/ul/li[1]/button")
 private WebElement clickJSAlert;
 @FindBy(xpath="//*[@id='content']/div/ul/li[2]/button")
 private WebElement clickJsConfirm;
 @FindBy(xpath="//*[@id='content']/div/ul/li[3]/button")
 private WebElement clickJsPrompt;
 
 public String clickJsAlert() {
	 clickJSAlert.click();
	String clickAlertText= driver.switchTo().alert().getText();
	 driver.switchTo().alert().accept();
	 System.out.println("click alert text is: "+clickAlertText);
	 return clickAlertText;
 }
 
 public String clickJsConfirm() {
	 clickJsConfirm.click();
		String clickAlertConfirm= driver.switchTo().alert().getText();
		
		 driver.switchTo().alert().accept();
		 System.out.println("clickAlertConfirm: "+clickAlertConfirm);
		 return clickAlertConfirm;
 }
 public String clickJsPrompt(String text) {
	 System.out.println("user in prompt method");
		
	 clickJsPrompt.click();
	
		driver.switchTo().alert().sendKeys(text);
		System.out.println("Text is: "+text);
		 String getText= driver.switchTo().alert().getText();
		 driver.switchTo().alert().accept();
		 System.out.println("getText: "+getText);
		 return getText;
 }
}
