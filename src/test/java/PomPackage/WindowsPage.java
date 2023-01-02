package PomPackage;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class WindowsPage  extends BaseClass{
	@FindBy(linkText = "Click Here")
	private WebElement clickLnk;

	public WindowsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean getNewTab() throws InterruptedException {
		clickLnk.click();
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
