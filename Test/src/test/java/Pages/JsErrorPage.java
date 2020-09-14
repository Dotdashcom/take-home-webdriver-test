package Pages;

import Utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JsErrorPage extends PageBase {

    @FindBy(xpath = "//p")
    WebElement jsErrorMessage;

      public void checkJsErrorMessage(){
          BrowserUtils.getElementText(jsErrorMessage);
          Assert.assertFalse(jsErrorMessage.getText().isEmpty());
      }
}
