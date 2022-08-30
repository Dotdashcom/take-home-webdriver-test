package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class HoverOverPage {

	WebDriver driver;

	public HoverOverPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Hovers')]")
	WebElement HOVEROVER_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/img")
	WebElement IMAGE1_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/img")
	WebElement IMAGE2_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[3]/img")
	WebElement IMAGE3_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[1]/div/a")
	WebElement VIEWPROFILE1_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div/a")
	WebElement VIEWPROFILE2_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[3]/div/a")
	WebElement VIEWPROFILE3_ELEMENT;

	@FindBy(how = How.XPATH, using = "/html/body/h2")
	WebElement INFO_ELEMENT;

	public void hoverOverMenu() {
		HOVEROVER_MENU_ELEMENT.click();
	}

	public void hoverOver() {

		Actions action = new Actions(driver);

		action.moveToElement(IMAGE1_ELEMENT).moveToElement(VIEWPROFILE1_ELEMENT).click().perform();

		String actualResult = "Sinatra doesn’t know this ditty.";
		String expectedResult = INFO_ELEMENT.getText();
		System.out.println("actual message: " + actualResult);
		System.out.println("expected message: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);

	}

}
