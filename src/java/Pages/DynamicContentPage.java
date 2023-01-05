package java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicContentPage {

	
	WebDriver driver;
	
	public DynamicContentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	
	@FindBy(xpath = "(//div[@class='large-10 columns'])[1]")
	WebElement content1;
	
	
	public void dynamicContent()
	{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='large-10 columns'])[1]")));
		String getContent1 = content1.getText();
		System.out.println(getContent1);
		
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='large-10 columns'])[1]")));
		String getContentAfterrefresh = content1.getText();
		System.out.println(getContentAfterrefresh);
		Assert.assertFalse(getContent1.equals(getContentAfterrefresh));
		
	}
	
}
