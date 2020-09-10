package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpeninNewTabPage extends Functions {

    @FindBy(xpath = "//div[@id='content']//a[text()='Click Here']")
    public WebElement linkToNewWindow;

    @FindBy(css = "div.example>h3")
    public WebElement newWindowMessage;



    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public OpeninNewTabPage() {

        PageFactory.initElements(driver, this);

    }
}
