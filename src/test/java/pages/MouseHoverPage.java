package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class MouseHoverPage {

	WebDriver driver;

	public MouseHoverPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(xpath = "//*[@id='content']/div/div[@class='figure']")
    List<WebElement> userImageList;

	private List<String> userLists;

	public MouseHoverPage hoverAllImages() {
		Actions action = new Actions(driver);
		userLists = new ArrayList<String>();
		WebElement userDetail;

		for (WebElement user : userImageList) {
			action.moveToElement(user).perform();
			userDetail = user.findElement(By.cssSelector("div.figcaption > h5"));
			if (userDetail.isDisplayed()) {
				userLists.add(userDetail.getText());
			}
		}
		return this;
	}

	public List<String> getUsersList() {
		return userLists;
	}

	// get url
	public MouseHoverPage getUrl() {
		driver.navigate().to(TestBase.url + "/hovers");
		return this;
	}
}
