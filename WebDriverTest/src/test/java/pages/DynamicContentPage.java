package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage extends Functions {

    @FindBy(xpath = "//div[@id='content']/div[3]/div[2]")
    public WebElement dynamicText;

    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public DynamicContentPage() {

        PageFactory.initElements(driver, this);

    }

}


