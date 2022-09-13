package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.TestBase;

public class ContextPage extends TestBase{
	
	@FindBy(id="hot-spot")
	WebElement box;
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void LandingPage() {
		driver.get(BaseUrl+"/context_menu");
		
	}
	public void rightClickBox() {
		Actions builder=new Actions(driver);
		builder.contextClick(box).build().perform();
	}
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	public String AlertText() {
		Alert al=driver.switchTo().alert();
		String AlertText=al.getText();
		return AlertText;
	}
	public void closeBrowser() {
		driver.quit();
	}
			
}
