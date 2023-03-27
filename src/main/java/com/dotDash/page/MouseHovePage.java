package com.dotDash.page;

import com.dotDash.page.common.BasePage;
import com.dotDash.utils.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Seb Geb
 *
 */
public class MouseHovePage extends BasePage {
	private WebDriver driver;

	public MouseHovePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='Hovers']")
	private WebElement hoverHeader;
	@FindBy(css = "img[alt='User Avatar']")
	private List<WebElement> userAvatarList;
	private String hoverElament="./following-sibling::div[@class='figcaption']";
	/**
	 * To check page header
	 *
	 * @author Seb Geb
	 *
	 */
	public void navigateToHoverPage() {
		navigateTo(TestProperties.getProperty("MOUSE_HOVER_URL"));
		assertEquals("Hover Page Elements Header",checkWebElementExist(hoverHeader), true);
	}
	/**
	 * To Validate Mouse Hover functionality
	 * @author Seb Geb
	 */
	
	public void validateFloatingMenuFeature() {
		Actions actions=new Actions(driver);
		for(WebElement eachAvatar:userAvatarList){
			actions.moveToElement(eachAvatar).build().perform();
			waitForElementExistance(eachAvatar.findElement(By.xpath(hoverElament)));
		}
	}
}
