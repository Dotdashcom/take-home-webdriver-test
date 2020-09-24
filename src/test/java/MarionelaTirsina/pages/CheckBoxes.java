package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxes extends BasePage{
     @FindBy(xpath = "//input[1]")
    public WebElement checkBox1;

     @FindBy(xpath = "//input[1]")
    public WebElement checkBox2;
}
