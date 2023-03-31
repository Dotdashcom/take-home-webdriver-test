package dotDashcom.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage {
	WebDriver driver;

	public MouseHoverPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.figure>img")
	private List<WebElement> image;

	@FindBy(css = "div.figcaption>h5")
	private List<WebElement> information;

	public String checkInfoForImage(int i) {
		Actions action = new Actions(driver);
		action.moveToElement(image.get(i - 1)).perform();
		return information.get(i - 1).getText();

	}
}
