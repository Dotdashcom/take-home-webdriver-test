package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MouseHoverPage {
	static WebDriver driver;

	public MouseHoverPage(WebDriver driver) {
		MouseHoverPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//div[@class = 'example']//child::div[@class = 'figure'][1]")
	WebElement BLANK_IMAGE_1_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@class = 'example']//child::div[@class = 'figure'][2]")
	WebElement BLANK_IMAGE_2_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@class = 'example']//child::div[@class = 'figure'][3]")
	WebElement BLANK_IMAGE_3_ELEMENT;
	@FindBy(how = How.XPATH, using = "//h5[contains(text(), 'name: user1')]")
	WebElement DISPLAYED_ADDITIONAL_INFO_FOR_IMAGE_1_ELEMENT;
	@FindBy(how = How.XPATH, using = "//h5[contains(text(), 'name: user2')]")
	WebElement DISPLAYED_ADDITIONAL_INFO_FOR_IMAGE_2_ELEMENT;
	@FindBy(how = How.XPATH, using = "//h5[contains(text(), 'name: user3')]")
	WebElement DISPLAYED_ADDITIONAL_INFO_FOR_IMAGE_3_ELEMENT;

//	Methods
	public void mouseHoverImgage1() {
		Actions action = new Actions(driver);
		action.moveToElement(BLANK_IMAGE_1_ELEMENT).build().perform();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void mouseHoverImgage2() {
		Actions action = new Actions(driver);
		action.moveToElement(BLANK_IMAGE_2_ELEMENT).build().perform();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void mouseHoverImgage3() {
		Actions action = new Actions(driver);
		action.moveToElement(BLANK_IMAGE_3_ELEMENT).build().perform();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateAdditionalInformationIsDisplayedForImage1WhenHoverHappens() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(DISPLAYED_ADDITIONAL_INFO_FOR_IMAGE_1_ELEMENT));
		Assert.assertTrue(DISPLAYED_ADDITIONAL_INFO_FOR_IMAGE_1_ELEMENT.isDisplayed(),
				"Additional information not displayed for image 1 !!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateAdditionalInformationIsDisplayedForImage2WhenHoverHappens() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(DISPLAYED_ADDITIONAL_INFO_FOR_IMAGE_2_ELEMENT));
		Assert.assertTrue(DISPLAYED_ADDITIONAL_INFO_FOR_IMAGE_2_ELEMENT.isDisplayed(),
				"Additional information not displayed for image 2 !!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateAdditionalInformationIsDisplayedForImage3WhenHoverHappens() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(DISPLAYED_ADDITIONAL_INFO_FOR_IMAGE_3_ELEMENT));
		Assert.assertTrue(DISPLAYED_ADDITIONAL_INFO_FOR_IMAGE_3_ELEMENT.isDisplayed(),
				"Additional information not displayed for image 3 !!!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
