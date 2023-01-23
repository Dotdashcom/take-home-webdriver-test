package PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class OpenInnewtabPage extends AbstractClass {
	WebDriver driver;

	public OpenInnewtabPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href='/windows/new']")
	WebElement newwindow;
	@FindBy(className = "example")
	WebElement windowtext;

	public String openNewWindow() {
		newwindow.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String newWinMessage = windowtext.getText();
		driver.switchTo().window(childId).close();
		driver.switchTo().window(parentId);
		return newWinMessage;

	}

}
