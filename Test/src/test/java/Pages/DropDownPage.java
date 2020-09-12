package Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DropDownPage extends PageBase {

    @FindBy(xpath = "//select[@id='dropdown']")
    WebElement dropdown;

    @FindBy(xpath = "//option[@value='2']")
    WebElement option2;

  public  void  selectOptions(){
      BrowserUtils.selectDropDown(dropdown,2);
  }

  public boolean option2IsSelected(){
      return BrowserUtils.elementIsSelected(option2);
  }

}
