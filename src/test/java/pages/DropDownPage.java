package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownPage extends BasePage {
  @FindBy(css = "#dropdown")
  WebElement dropdown;
  @FindBy(xpath = "//option[contains(text(),'Option 1')]")
  WebElement option1;
  @FindBy(xpath = "//option[contains(text(),'Option 2')]")
  WebElement option2;

  public void dropDownMenu() throws InterruptedException {
   dropdown.click();
   Thread.sleep(2000);
  }

  public void selectOption1() {
    option1.click();
  }
  public void selectOption2() {
    option2.click();
  }
  public boolean option1IsSelected(){
    return option1.isSelected();
  }
  public boolean option2IsSelected(){
    return option2.isSelected();
  }
}
