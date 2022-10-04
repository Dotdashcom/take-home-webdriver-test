package dotdash.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage {
	
public WebDriver driver;
	
	

	@FindBy(xpath="//div[@id='start']/button")
	private WebElement startButton;
	
	
	
	public DynamicLoadingPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void clickStartAndVerifyMessage()  {
		
		startButton.click();
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(), \"Hello World!\")]")));
		Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(), \"Hello World!\")]")).getText(),"Hello World!");
		
	}

}
