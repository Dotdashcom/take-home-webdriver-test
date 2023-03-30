package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageComponents.DragDropPage;


public class DragDropTest
{
	WebDriver driver;
	DragDropPage dragDropPage;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("--remote-allow-origins=*");
		browserOptions.setHeadless(true);
		driver = new ChromeDriver(browserOptions);
		dragDropPage  = new DragDropPage(driver);
		driver.manage().window().maximize();
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void dragAtoB()
	{
		driver.get("http://localhost:7080/drag_and_drop");
		WebElement fromElement = dragDropPage.getColumnA();
		WebElement toElement = dragDropPage.getColumnB();
		Actions actions = new Actions(driver);
		Action dragDrop = actions.clickAndHold(fromElement).moveToElement(toElement).release().build();
		dragDrop.perform();
		assertEquals(dragDropPage.getColumnAHeader(),"B");
	}	
	@Test
	public void dragBtoA()
	{
		driver.get("http://localhost:7080/drag_and_drop");
		WebElement toElement = dragDropPage.getColumnA();
		WebElement fromElement = dragDropPage.getColumnB();
		Actions actions = new Actions(driver);
		Action dragDrop = actions.clickAndHold(fromElement).moveToElement(toElement).release().build();
		dragDrop.perform();
		assertEquals(dragDropPage.getColumnAHeader(),"B");
	}
}
