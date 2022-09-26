package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPageObj extends CommonMethods {

    public CheckBoxPageObj() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "(//*[@id='checkboxes']/input)[1]")
    private WebElement box1;

    @FindBy(xpath = "(//*[@id='checkboxes']/input)[2]")
    private WebElement box2;

    public WebElement checkBox1() {
        return box1;
    }

    public WebElement checkBox2() {
        return box2;
    }
}
