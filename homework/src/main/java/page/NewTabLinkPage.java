package page;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class NewTabLinkPage {

	WebDriver driver;

	public NewTabLinkPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Multiple Windows')]")
	WebElement MULTIPLEWINDOW_MENU_ELEMENT;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Click Here')]")
	WebElement CLICK_NEW_ELEMENT;

	public void newTabLinkMenu() {
		MULTIPLEWINDOW_MENU_ELEMENT.click();
	}

	public void assertNewWindowTab() {

		String parent = driver.getWindowHandle();
		System.out.println(driver.getTitle());

		// clicking new window
		driver.findElement(By.xpath("//a[contains(@href, '/windows/new')]")).click();

		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("total windows: " + count);

		// switching the driver from parent to child
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
			}
		}

		// assertion that we landed on the new window
		String actualWindow = "New Window";
		String expectedWindow = driver.getTitle();
		Assert.assertEquals(actualWindow, expectedWindow);

		driver.close();

		// switching back to parent
		driver.switchTo().window(parent);
		System.out.println("parent window Title: " + driver.getTitle());
	}

}
