package tests;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestNewTab{

  WebDriver driver;

  @BeforeMethod
  public void initialize() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
  }
  @Test
  public void TestOpenNewTab() {
    String url = "http://localhost:7080/windows";
    driver.get(url);

    By clickHereLinkXpath = By.xpath("//div[@class='example']/descendant::a[text()='Click Here']");

    driver.findElement(clickHereLinkXpath).click();

    //Open a new tab
    ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(windows.get(1));
    //Look for Title
    Assert.assertEquals(driver.getTitle(),"New Window");

    driver.switchTo().defaultContent();
  }

  @AfterMethod
  public void  tearDown() {
    driver.quit();
  }

}



