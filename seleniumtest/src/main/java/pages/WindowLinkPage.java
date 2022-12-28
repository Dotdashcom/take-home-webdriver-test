package pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class WindowLinkPage extends GenericPage {

	@FindBy(linkText = "Click Here")
	private WebElement clickLink;

	public WindowLinkPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean getNewTab() throws InterruptedException {
		clickLink.click();
		Thread.sleep(2000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String handle: windowHandles) {
			driver.switchTo().window(handle);
			if("New Window".equals(driver.getTitle())) {
				return true;
			}
		}
		return false;
	}
}