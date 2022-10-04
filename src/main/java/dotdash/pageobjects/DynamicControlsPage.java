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

public class DynamicControlsPage {
	
public WebDriver driver;
	
	

	@FindBy(xpath="//form[@id='input-example']/button")
	private WebElement textfieldButton;
	
	@FindBy(xpath="//form[@id='checkbox-example']/button")
	private WebElement checkboxButton;
	
	@FindBy(xpath="//form[@id='input-example']/input")
	private WebElement textfield;
	
	@FindBy(id="checkbox")
	private WebElement checkbox;
	
	
	public DynamicControlsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void addRemoveCheckbox()  {
		
		checkboxButton.click();
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(3));
		w.until(ExpectedConditions.invisibilityOf(checkbox));
		Assert.assertEquals((driver.findElements(By.id("checkbox"))).size()==0,true);
		checkboxButton.click();
		w.until(ExpectedConditions.visibilityOf(checkbox));
		Assert.assertEquals((driver.findElements(By.id("checkbox"))).size()==0,false);
		
	}
	
	public void enableDisableTextfield() throws InterruptedException  {
		
		textfieldButton.click();
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(3));
		w.until(ExpectedConditions.elementToBeClickable(textfield));
		Assert.assertEquals(textfield.isEnabled(),true);
		Thread.sleep(1000);
		textfieldButton.click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), \"It's disabled!\" )]")));
		Assert.assertEquals(textfield.isEnabled(),false);
		
	}
	



}
