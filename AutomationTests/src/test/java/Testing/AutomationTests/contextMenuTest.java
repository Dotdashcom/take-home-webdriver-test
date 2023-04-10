package Testing.AutomationTests;

import java.io.IOException;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import pageobjects.ContextMenuPage;
import resources.base;

public class contextMenuTest extends base{
	public WebDriver driver;
	ContextMenuPage context;


	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("contextUrl"));

	}


	@Test
	public void contextMenu() throws IOException, InterruptedException {	

		context= new ContextMenuPage(driver);
		context.rightClick();
		String alertMessage=context.getAlertMessage();
		System.out.println(alertMessage);
		AssertJUnit.assertEquals(alertMessage, "You selected a context menu");
	}


	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}

	}

