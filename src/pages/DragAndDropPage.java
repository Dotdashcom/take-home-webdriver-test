package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.TestBase;

public class DragAndDropPage extends TestBase {
	
	@FindBy(xpath="//div[@id='column-a']")
	WebElement ElementA;
	@FindBy(xpath="//div[@id='column-b']")
	WebElement ElementB; 
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void LandingPage() {
		driver.get(BaseUrl+"/drag_and_drop");
		
	}
	public void dragAndDrop() {
		Actions builder=new Actions(driver);
		builder.dragAndDrop(ElementA, ElementB).build().perform();
	}
	public void closeBrowser() {
		driver.quit();
	}

}
