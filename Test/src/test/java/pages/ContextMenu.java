package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContextMenu {


	WebDriver driver;
	public ContextMenu(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(id="hot-spot")
	WebElement box;

	public void rightClickOnBox(){
		Actions a = new Actions(driver);
		a.moveToElement(box).contextClick().build().perform();

	}
	public void assertionOfAlert(){

		WebDriverWait wait = new WebDriverWait(driver, 15);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		Assert.assertEquals("You selected a context menu", alertText);
		alert.accept();
	}


}
