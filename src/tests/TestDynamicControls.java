package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class TestDynamicControls {
  WebDriver driver;

  @BeforeMethod
  public void initialize() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void testDynamicControls() {

    String url = "http://localhost:7080/dynamic_controls";

    driver.get(url);

    // 1.click on the remove button
    WebElement removeButton = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
    removeButton.click();
    // explicit wait
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

    //2. is there any checkbox displayed on the page
    List<WebElement> anyCheckbox = driver.findElements(By.id("checkbox"));
    assertTrue(anyCheckbox.isEmpty());

    // 3. click on add button , it has same xpath as remove button
    //*[@id="checkbox-example"]/button
    removeButton.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));

    //4. see if checkbox is present
    assertTrue(true);

    // 5. click on the Enable button
    WebElement enableButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));
    enableButton.click();

    // 6. explicit wait and check if textbox is enabled
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='input-example']/input")));
    assertTrue(true);

    // 7. click on disable button , xpath is same as that of enable
    enableButton.click();

    //8. explicit wait and check if textbox is disabled
    wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='message']"),"It's disabled!"));
    assertTrue(true);

  }

  @AfterMethod
  public void  tearDown() {
    driver.close();
  }

}
