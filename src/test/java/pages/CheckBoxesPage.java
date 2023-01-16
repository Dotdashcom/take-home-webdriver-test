package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxesPage extends BasePage {
  @FindBy(xpath = "(//input[@type='checkbox'])[1]")
  WebElement checkbox1;
  @FindBy(xpath = "(//input[@type='checkbox'])[2]")
  WebElement checkbox2;

  public boolean checkbox1IsDisplayed() {
    return checkbox1.isDisplayed();
  }

  public boolean checkbox2IsDisplayed() {
    return checkbox2.isDisplayed();
  }

  public void selectCheckBox1() {
    checkbox1.click();
  }

  public void selectCheckBox2() {
    checkbox2.click();
  }

  public boolean checkbox1IsSelected() {
    return checkbox1.isSelected();
  }

  public boolean checkbox2IsSelected() {
    return checkbox2.isSelected();
  }


}
