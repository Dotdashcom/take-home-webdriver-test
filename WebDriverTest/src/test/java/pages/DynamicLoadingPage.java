package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends Functions {


    @FindBy(xpath = "//div[@id='start']/button")
    public WebElement startBtn;

    @FindBy(xpath = "//div[@id='finish']/h4")
    public WebElement message;



    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public DynamicLoadingPage() {

        PageFactory.initElements(driver, this);

    }
}
