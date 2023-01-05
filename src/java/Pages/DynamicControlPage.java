package java.Pages;

import javax.servlet.FilterRegistration.Dynamic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicControlPage {
	
	WebDriver driver;
	
	public DynamicControlPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement removeButton;
	
	
	@FindBy(xpath = "//button[contains(text(),'Enable')]")
	WebElement enableButton;
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement addButton;
	
	@FindBy(xpath = "//button[contains(text(),'Disable')]")
	WebElement disableButton;
	
	
	@FindBy(xpath = "//form[@id='input-example']//input")
	WebElement textbox;
	
	@FindBy(xpath = "//form//p")
	WebElement checkboxgonemsgs;
	
	
	public void handlingDynamicContent() throws InterruptedException
	{
		//checkbox.click();
		removeButton.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));
		
		
		Assert.assertEquals(checkboxgonemsgs.getText(), "It's gone!");
		
		
	
		System.out.println("remove button clicked");
//		
		addButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Remove')]")));
		Assert.assertTrue(checkbox.isDisplayed());
		System.out.println("add button clicked");
		
		
		enableButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Disable')]")));
		boolean anytextfield = textbox.isEnabled();
		Assert.assertEquals(anytextfield,true);
		System.out.println("enable button clicked");
		
		disableButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enable')]")));
		boolean anytextfield1 = !textbox.isEnabled();
		Assert.assertEquals(anytextfield1,true);
		System.out.println("disable button clicked");
		
//		driver.navigate().refresh();
//		
//		Assert.assertTrue(addButton.isDisplayed(), "content not changed on page refresh");
//		
//		
//		enableButton.click();
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Disable')]")));
//		
//		Assert.assertTrue(disableButton.isDisplayed(), "Disable button is not displayed hence content did not change on page refresh");
	}
	
	
	
	
	
	
	
	
	
	

}
