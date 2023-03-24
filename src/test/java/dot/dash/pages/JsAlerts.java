package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JsAlerts {
    public JsAlerts() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

  public WebElement buttons(String text){
      return Driver.getDriver().findElement(By.xpath("//button[.='"+text+"']"));
  }
        @FindBy(id = "result")
    public WebElement result;

}
