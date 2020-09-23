package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxesPage extends BasePage {

    @FindBy (xpath = "//input[1]")
    public WebElement checkBox1;

    @FindBy (xpath = "//input[2]")
    public WebElement checkBox2;
}
