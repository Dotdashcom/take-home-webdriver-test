package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class IframePage {

	WebDriver driver;

	public IframePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Frames')]")
	WebElement FRAME_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'iFrame')]")
	WebElement IFRAME_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@type='button' and @class='tox-notification__dismiss tox-button tox-button--naked tox-button--icon']")
	WebElement BUTTON_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id='mce_0_ifr']")
	WebElement SWITCHFRAME_MENU_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"tinymce\"]")
	WebElement TEXTBOX_ELEMENT;

	public void frameMenu() {
		FRAME_MENU_ELEMENT.click();
		IFRAME_MENU_ELEMENT.click();
		BUTTON_MENU_ELEMENT.click();
	}

	public void iframeElement() {

		// BUTTON_MENU_ELEMENT.sendKeys("hello This is where ");

		driver.switchTo().frame(SWITCHFRAME_MENU_ELEMENT);
		TEXTBOX_ELEMENT.clear();
		TEXTBOX_ELEMENT.sendKeys("Hello world");

		String actualResult = "Hello world";
		String expectedResult = TEXTBOX_ELEMENT.getText();
		System.out.println("actual message: " + actualResult);
		System.out.println("expected message: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);

	}

}
