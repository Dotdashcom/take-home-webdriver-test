package java.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPages {

	
	WebDriver driver;
	
	public ContextMenuPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[@id='hot-spot']")
	WebElement hotspot;
	
	
	public void clickContextMenu()
	{
//	By rightClick = By.xpath("//div[@id='hot-spot']");
//	
//	
//	Actions actions = new Actions(driver);
//	WebElement rt = driver.findElement(rightClick);
//	actions.contextClick(rt).perform();
//	
//	WebDriverWait wait = new WebDriverWait(driver, 30);
//	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//	System.out.println(alert.getText());
//	alert.accept();
	
	
	Actions actions = new Actions(driver);
	WebElement link = driver.findElement(By.xpath("//div[@id='hot-spot']"));
	actions.contextClick(link).perform();
	//actions.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	System.out.println(alert.getText());
	
	Assert.assertEquals("You selected a context menu", alert.getText());
	alert.accept();
	
	
	
	
	}
}
