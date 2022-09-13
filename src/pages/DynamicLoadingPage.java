package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Util.TestBase;

public class DynamicLoadingPage extends TestBase {

	@FindBy(xpath="//button[contains(text(),'Start')]")
	WebElement StartButton;
	@FindBy(xpath="//div[@id='finish']/h4")
	WebElement HelloWorld;
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/dynamic_loading/2");	
	}
	public void clickonStart() {
		StartButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(HelloWorld));	
	}
	public String VerifyText() {
		return HelloWorld.getText();
	}
	public void closeBrowser() {
		driver.quit();
	}
}
