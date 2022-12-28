package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class HoversPage extends GenericPage {

	@FindBy(xpath = "(//div[@class='figure'])[1]")
	private WebElement image1;

	@FindBy(xpath = "(//div[@class='figure'])[2]")
	private WebElement image2;

	@FindBy(xpath = "(//div[@class='figure'])[3]")
	private WebElement image3;

	public HoversPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean getHoversBool() throws InterruptedException {
		Actions actions = new Actions(driver);
		
		Thread.sleep(2000);
		actions.moveToElement(image1).perform();
		String text1 = image1.getText();
		
		Thread.sleep(2000);
		actions.moveToElement(image2).perform();
		String text2 = image2.getText();
		
		Thread.sleep(2000);
		actions.moveToElement(image3).perform();
		String text3 = image3.getText();
		
		if("name: user1\nView profile".equals(text1) && "name: user2\nView profile".equals(text2) && "name: user3\nView profile".equals(text3)) {
			return true;
		}
		return false;
	}
}