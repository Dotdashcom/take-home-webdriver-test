package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicLoadingPage {
    public DynamicLoadingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//button[contains(text(),'Start')]")
    public WebElement Start;

    @FindBy(xpath = "//h4[contains(text(),'Hello World!')]")
    public WebElement hellotext;

}

//h4[contains(text(),'Hello World!')]
