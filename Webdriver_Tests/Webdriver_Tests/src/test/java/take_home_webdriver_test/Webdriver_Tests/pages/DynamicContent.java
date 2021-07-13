package take_home_webdriver_test.Webdriver_Tests.pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class DynamicContent{
  WebDriver driver;
  GenericMethods gnrcMthds;
  
  @FindBy(id="content")
  public WebElement content;
  
  @FindBy(className ="large-10 columns")
  public List<WebElement> contentText;

  @FindBy(xpath =".//*[@class='large-2 columns']//img")
  public List<WebElement> contentImg;
  
  public DynamicContent(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver, this);
      gnrcMthds = PageFactory.initElements(driver, GenericMethods.class);
  }

  public boolean verifyTheContent() {
	  boolean flag=false;
	  List<String> txtBfrReresh=new ArrayList<String>();
	  for(WebElement elmnt:contentText) {
		  txtBfrReresh.add(elmnt.getText());
	  }
	  driver.navigate().refresh();
	  for(WebElement elmnt:contentText) {
		  if(elmnt.getText().equals(txtBfrReresh.get(contentText.indexOf(elmnt)))) {
			  flag=false;
		  }else {
			  flag= true;
			  break;
		  }
	  }
	return flag;
  }
}
