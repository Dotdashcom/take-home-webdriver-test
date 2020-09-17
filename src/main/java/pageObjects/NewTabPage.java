package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewTabPage {
  public WebDriver driver;
  By linkLocator = By.xpath("//*[@id=\'content\']/div/a");
  
  public NewTabPage(WebDriver driver)
  {
	  this.driver=driver;
  }
  
  public WebElement getLinkLocator()
  {
	  return driver.findElement(linkLocator);
  }
  
}
