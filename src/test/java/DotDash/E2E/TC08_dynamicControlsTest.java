package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.TC08_dynamicControlsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC08_dynamicControlsTest extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}

	//first check all the boxes and assert it
	@Test
	public void testDynamicContent() throws InterruptedException{
		/*	Testing Scenario:
	  		Test that the content changes on each refresh
		 */
		TC08_dynamicControlsObject dco = new TC08_dynamicControlsObject(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		dco.getDynamicControlsLink().click();
		
		dco.getButton().click();
		WebElement checkText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		AssertJUnit.assertEquals(checkText.getText(),"It's gone!");
		AssertJUnit.assertEquals(dco.getButton().getText(),"Add");
		
		//Test clicks on Add Button and checkbox display
		dco.getButton().click();
		WebElement checkButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		AssertJUnit.assertTrue(checkButton.isDisplayed());
		AssertJUnit.assertTrue(dco.getCheckbox2().isDisplayed());
		
		driver.navigate().refresh();
		//Test on enable button
		//Firstly input field should be disabled
		AssertJUnit.assertTrue(!dco.getEnableInput().isEnabled());
		
		dco.getEnableButton().click();
		WebElement enableInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/input")));
		AssertJUnit.assertTrue(enableInput.isEnabled());
		enableInput.sendKeys("hello world!");
		
		dco.getEnableButton().click();
		WebElement disableText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@id='message']")));
		AssertJUnit.assertEquals(disableText.getText(), "It's disabled!");
		AssertJUnit.assertTrue(!dco.getEnableInput().isEnabled());
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
