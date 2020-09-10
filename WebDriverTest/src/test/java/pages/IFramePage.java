package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage extends Functions {

    @FindBy(xpath = "//div[@id='mceu_3']//button[@role='presentation']")
    public WebElement boldBtn;

    @FindBy(id = "tinymce")
    public WebElement textBox;

    @FindBy(id = "mce_0_ifr")
    public WebElement iFrame;



    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public IFramePage() {

        PageFactory.initElements(driver, this);

    }
}
