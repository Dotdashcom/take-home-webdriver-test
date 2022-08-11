package tests;

import org.junit.After;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TestJavaScriptAlerts {

  private WebDriver driver;

  @BeforeTest
  public void initialize() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void testJSAlert() {

    String url = "http://localhost:7080/javascript_alerts";
    driver.get(url);

    //1. validate click for JS Alert button
    WebElement JSAlertButton = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button"));
    JSAlertButton.click();

    String JSAlertMsg = driver.switchTo().alert().getText();
    System.out.println(JSAlertMsg);

    //validate the alert text
    Assert.assertEquals("I am a JS Alert", JSAlertMsg);

// accept the alert
    driver.switchTo().alert().accept();

// 2. click on js confirm button
    WebElement JSConfirmButton = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
    JSConfirmButton.click();

    String JSConfirmMsg = driver.switchTo().alert().getText();
    System.out.println(JSConfirmMsg);

// validate js confirm alert text
    Assert.assertEquals("I am a JS Confirm",JSConfirmMsg);

    //accept the alert
    driver.switchTo().alert().accept();


    // 3. click on js Prompt
    WebElement JSPromptButton = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
    JSPromptButton.click();

    //type the text in alert box
    String text="test";
    driver.switchTo().alert().sendKeys(text);
    driver.switchTo().alert().accept();

    WebElement enteredTextLoc = driver.findElement(By.xpath("//*[@id='result']"));



    //verify the entered text
    Assert.assertEquals(enteredTextLoc.getText(),"You entered: "+text);


  }
  @AfterTest
  public void teardown() {
    driver.quit();
  }
}
