package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class MouseHoverPage extends BrowserUtilities {

	public MouseHoverPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//img[@alt='User Avatar'])[1]")
	WebElement image1;

	@FindBy(how = How.XPATH, using = "(//img[@alt='User Avatar'])[2]")
	WebElement image2;

	@FindBy(how = How.XPATH, using = "(//img[@alt='User Avatar'])[3]")
	WebElement image3;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'name: user1')]")
	WebElement UserName1;

	@FindBy(how = How.XPATH, using = "//*[@id='content']//descendant::a[@href='/users/1']")
	WebElement btn_viewProfile_User1;
	
	@FindBy(how = How.XPATH, using = "//*[@id='content']//descendant::a[@href='/users/2']")
	WebElement btn_viewProfile_User2;
	
	@FindBy(how = How.XPATH, using = "//*[@id='content']//descendant::a[@href='/users/3']")
	WebElement btn_viewProfile_User3;
	
	@FindBy(how = How.XPATH, using = "//h2")
	WebElement viewProfilePageText;

	public void getUrl() {
		driver.get(BaseTest.getURL("hovers"));
	}

	public Boolean mouseHoverImage1() {
		MoveMouse(BaseTest.driver, image1);
		return isElementPresent(btn_viewProfile_User1, "View profile");
	}

	public Boolean mouseHoverImage2() {
		MoveMouse(BaseTest.driver, image2);
		return isElementPresent(btn_viewProfile_User2, "View profile");
	}

	public Boolean mouseHoverImage3() {
		MoveMouse(BaseTest.driver, image3);
		return isElementPresent(btn_viewProfile_User3, "View profile");
	}
	public void clickviewProfileImage1() {
		btn_viewProfile_User1.click();
	}
	public String getViewProfilePageText() {
		return getText(viewProfilePageText);
	}
	
}
