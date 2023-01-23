package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class MouseOverPage extends AbstractClass {
	WebDriver driver;
	@FindBy(className = "figure")
	WebElement figurehover;
	@FindBy(className = "figcaption")
	WebElement figuretext;

	public MouseOverPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@SuppressWarnings("unused")
	public boolean mousehover() {
		for (int i = 0; i < 3; i++) {
			Actions a = new Actions(driver);
			a.moveToElement(figurehover).build().perform();
			String hovermessage = figuretext.getText();
			if (hovermessage.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}
		return false;

	}

}
