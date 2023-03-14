package testPackages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class MouseHoverTest {

  private WebDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("http://localhost:7080/hovers");
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testMouseHover() {

    WebElement firstImage = driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
    WebElement secondImage = driver.findElement(By.cssSelector(".figure:nth-of-type(2)"));
    WebElement thirdImage = driver.findElement(By.cssSelector(".figure:nth-of-type(3)"));

    performMouseHover(firstImage);
    Assert.assertTrue("Additional information not displayed for first image", isAdditionalInfoDisplayed(firstImage));

    performMouseHover(secondImage);
    Assert.assertTrue("Additional information not displayed for second image", isAdditionalInfoDisplayed(secondImage));

    performMouseHover(thirdImage);
    Assert.assertTrue("Additional information not displayed for third image", isAdditionalInfoDisplayed(thirdImage));

  }

  private void performMouseHover(WebElement element) {
    org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(driver);
    action.moveToElement(element).perform();
  }

  private boolean isAdditionalInfoDisplayed(WebElement element) {
    return element.findElement(By.cssSelector("div > h5")).isDisplayed();
  }

}
