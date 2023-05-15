package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage {
	private WebDriver driver;

	public MouseHoverPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "(//div[@class='example']//img[1])[1]")
	private WebElement image1;

	@FindBy(how = How.XPATH, using = "(//div[@class='example']//img[1])[2]")
	private WebElement image2;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='example']//img[1])[3]")
	private WebElement image3;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='name: user1']")
	private WebElement message1;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='name: user2']")
	private WebElement message2;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='name: user3']")
	private WebElement message3;
	
	public boolean moveTo1() {
		Actions action = new Actions(driver);
		action.moveToElement(image1).build().perform();
		return message1.isDisplayed();
	}
	
	public boolean moveTo2() {
		Actions action = new Actions(driver);
		action.moveToElement(image2).build().perform();
		return message2.isDisplayed();
	}
	
	public boolean moveTo3() {
		Actions action = new Actions(driver);
		action.moveToElement(image3).build().perform();
		return message3.isDisplayed();
	}
}
