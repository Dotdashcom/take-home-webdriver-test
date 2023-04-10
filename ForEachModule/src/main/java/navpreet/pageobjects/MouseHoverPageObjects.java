package navpreet.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MouseHoverPageObjects {

	WebDriver driver;
	Actions actions;
	String text;

	public MouseHoverPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Hovers']")
	private WebElement clickHovers;

	@FindBy(css = "div.figcaption h5")
	private List<WebElement> information;

	@FindBy(css = "div.figure img")
	private List<WebElement> images;

	public void ClickHovers() {
		clickHovers.click();
	}

	public void mouseHover() {
		actions = new Actions(driver);

		for (int image = 0; image < images.size(); image++) {
			actions.moveToElement(images.get(image)).build().perform();
			text = information.get(image).getText();
			if (image == 0)
				Assert.assertEquals(text, "name: user1");
			else if (image == 1)
				Assert.assertEquals(text, "name: user2");
			else
				Assert.assertEquals(text, "name: user3");
		}
	}

}
