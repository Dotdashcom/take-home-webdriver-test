package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class ContextMenuPage extends AbstractClass {

	WebDriver driver;
	@FindBy(id = "hot-spot")
	WebElement hotstop;

	public ContextMenuPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String rightClick() {
		Actions click = new Actions(driver);
		click.contextClick(hotstop).perform();
		String message = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return message;
	}
}
