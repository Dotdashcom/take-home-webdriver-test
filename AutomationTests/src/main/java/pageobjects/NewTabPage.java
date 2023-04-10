package pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTabPage {
	WebDriver driver;

	public NewTabPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Click Here")
	private WebElement link;

	public String openAndSwitchToNewTab() {
		link.click();
		Set<String> tabs=driver.getWindowHandles();
		Iterator<String> it=tabs.iterator();
		String mainTab=it.next();
		String newTab=it.next();
		driver.switchTo().window(newTab);
		return driver.getCurrentUrl();
	}

	public String checkNewTabText() {
		return driver.getTitle();
	}

}
