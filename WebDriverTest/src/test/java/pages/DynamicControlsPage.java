package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage extends Functions {

    @FindBy(xpath = "//form[@id='checkbox-example']/button")
    public WebElement removeAddBtn;

    @FindBy(xpath = "//form[@id='input-example']/button")
    public WebElement enableDisableBtn;

    @FindBy(id = "checkbox")
    public WebElement checkbox;

    @FindBy(xpath = "//form[@id='input-example']/input")
    public WebElement textBox;

    @FindBy(xpath = "//form[@id='input-example']/p")
    public WebElement textBoxMessage;

    @FindBy(xpath = "//form[@id='checkbox-example']/p")
    public WebElement checkboxMessage;



    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public DynamicControlsPage() {

        PageFactory.initElements(driver, this);

    }

}
