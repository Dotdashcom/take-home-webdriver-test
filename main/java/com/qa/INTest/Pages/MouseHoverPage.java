package com.qa.INTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.INTest.TestBase.TestBase;

public class MouseHoverPage extends TestBase {

	@FindBy(linkText = "Hovers")
	WebElement hoversLink;

	@FindBy(xpath = "(//div[@class='figure'])[1]")
	WebElement firstImage;

	@FindBy(xpath = "(//div[@class='figure'])[2]")
	WebElement secondImage;

	@FindBy(xpath = "(//div[@class='figure'])[3]")
	WebElement thirdImage;

	@FindBy(xpath = "//h5[contains(text(),'name: user1')]")
	WebElement firstUser;

	@FindBy(xpath = "//h5[contains(text(),'name: user2')]")
	WebElement secondUser;

	@FindBy(xpath = "//h5[contains(text(),'name: user3')]")
	WebElement thirdUser;

	public MouseHoverPage() {

		PageFactory.initElements(driver, this);

	}

	public void clickOnMouseHover() {
		hoversLink.click();
	}

	public String hoverOnFirstImage() {
		Actions builder = new Actions(driver);
		builder.moveToElement(firstImage).build().perform();
		return firstUser.getText();

	}

	public boolean hoverOnSecondImage() {
		Actions builder = new Actions(driver);
		builder.moveToElement(secondImage).build().perform();
		return secondUser.isDisplayed();

	}

	public String hoverOnThirdImage() {
		Actions builder = new Actions(driver);
		builder.moveToElement(thirdImage).build().perform();
		return thirdUser.getText();

	}

}
