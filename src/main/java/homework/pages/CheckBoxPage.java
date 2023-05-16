package homework.pages;

import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {

    public CheckBoxPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[type='checkbox']:nth-of-type(1)")
    public WebElement checkBox1;

    @FindBy(css = "input[type='checkbox']:nth-of-type(2)")
    public WebElement checkBox2;


}
