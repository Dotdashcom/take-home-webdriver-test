package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class MouseHover extends BaseClass{
	@FindBy(xpath = "(//div[@class='figure'])[1]")
	private WebElement img1;

	@FindBy(xpath = "(//div[@class='figure'])[2]")
	private WebElement img2;

	@FindBy(xpath = "(//div[@class='figure'])[3]")
	private WebElement img3;

	public  MouseHover() {
		PageFactory.initElements(driver, this);
	}

	public boolean getHoversBool() throws InterruptedException {
		Actions actions = new Actions(driver);

		Thread.sleep(2000);
		actions.moveToElement(img1).perform();
		String text1 = img1.getText();

		Thread.sleep(2000);
		actions.moveToElement(img2).perform();
		String text2 = img2.getText();

		Thread.sleep(2000);
		actions.moveToElement(img3).perform();
		String text3 = img3.getText();

		if("name: user1\nView profile".equals(text1) && "name: user2\nView profile".equals(text2) && "name: user3\nView profile".equals(text3)) {
			return true;
		}
		return false;
	}

	
}
