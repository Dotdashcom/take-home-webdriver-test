package tests;



import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class TestContextMenu {

  WebDriver driver;

  @BeforeSuite
  public void initialize() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void testContextMenu() throws InterruptedException {
    String url = "http://localhost:7080/context_menu";
    String alertContent = "You selected a context menu";
    driver.get(url);


    Actions a = new Actions(driver);
    WebElement contextMenu = driver.findElement(By.xpath("//div[contains(@id,'hot-spot')]"));
    a.contextClick(contextMenu).perform();


    //switch  alert and get the text
    Alert alert = driver.switchTo().alert();
    Thread.sleep(1000);



    Assert.assertTrue(alert.getText().contains(alertContent));
    System.out.println(alert.getText());



    //accept the alert
    alert.accept();
    contextMenu.click();
  }

  @AfterMethod
  public void  tearDown() {
    driver.quit();
  }

}
