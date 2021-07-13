package take_home_webdriver_test.Webdriver_Tests.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class MouseHover{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(className="figure")
  public List<WebElement> figures;

  @FindBy(tagName ="h5")
  public WebElement name;
  
  @FindBy(xpath ="//h5//following-sibling::a[text()='View profile']")
  public WebElement vwPrfleLink;
  
  public MouseHover(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }
 
  public void mouseHoverOnElement(WebElement elmnt) {
	  Actions action=new Actions(driver);
	  action.moveToElement(elmnt);
  }
  
  public boolean verifyTextDisplayedAfterMouseHover() {
	  boolean flag=false;
	  for(WebElement elmnt:figures) {
		  mouseHoverOnElement(elmnt);
		  if (ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='name: user"+(figures.indexOf(elmnt)+1)+"']"))==null || ExpectedConditions.visibilityOf(vwPrfleLink)==null)
			  break;
		  else
			  flag= true;
	  }
	return flag;
  }
}
