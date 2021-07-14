package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.TC09_dynamicLoadingObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

public class TC09_dynamicLoadingTest extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}

	//first check all the boxes and assert it
	@Test
	public void testDynamicContent() throws InterruptedException{
		TC09_dynamicLoadingObject dlo = new TC09_dynamicLoadingObject(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		dlo.getDynamicLoadingLink().click();
		dlo.getExampleLink().click();
		dlo.getExampleButton().click();
		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
		
		AssertJUnit.assertTrue(text.isDisplayed());
		AssertJUnit.assertEquals(text.getText(), "Hello World!");
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
