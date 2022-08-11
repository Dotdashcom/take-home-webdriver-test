package tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class TestDropDown {

  WebDriver driver;

  @BeforeSuite
  public void initialize() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void testDropdown() throws InterruptedException {
    String url = "http://localhost:7080/dropdown";

    driver.get(url);


    WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
    Select selectedOption = new Select(dropDown);


    selectedOption.selectByVisibleText("Option 1");
    Thread.sleep(1000);

    Assert.assertTrue(selectedOption.getFirstSelectedOption().getText().equals("Option 1"));

    selectedOption.selectByVisibleText("Option 2");
    Thread.sleep(1000);

    Assert.assertTrue(selectedOption.getFirstSelectedOption().getText().equals("Option 2"));

  }

  @AfterMethod
  public void  tearDown() {
    driver.close();
  }
}
