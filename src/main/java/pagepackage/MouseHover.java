package pagepackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepackage.BaseTest;

public class MouseHover extends BaseTest {

	public MouseHover() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/img")
	private static WebElement img1;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/img")
	private static WebElement img2;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[3]/img")
	private static WebElement img3;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[1]/div/h5")
	private static WebElement user1;
	
	
	public void img1() {
		action=new Actions(driver);
		action.moveToElement(img1).build().perform();
		user1.getText().toString();
		Assert.assertEquals(user1.getText().toString(), "name: user1");
	}
	
	public void img2() {
		action=new Actions(driver);
		action.moveToElement(img1).build().perform();
		user1.getText().toString();
		Assert.assertEquals(user1.getText().toString(), "name: user2");
	}
	
	public void img3() {
		action=new Actions(driver);
		action.moveToElement(img1).build().perform();
		user1.getText().toString();
		Assert.assertEquals(user1.getText().toString(), "name: user3");
	}
	
}