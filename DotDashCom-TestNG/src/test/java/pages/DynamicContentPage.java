package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicContentPage {
    public DynamicContentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[@class='large-2 columns'])[1]/img")
    public WebElement img1;

    @FindBy(xpath = "(//*[@class='large-2 columns'])[2]/img")
    public WebElement img2;

    @FindBy(xpath = "(//*[@class='large-2 columns'])[3]/img")
    public WebElement img3;

    @FindBy(xpath = "(//*[@class='large-10 columns'])[1]")
    public WebElement text1;

    @FindBy(xpath = "(//*[@class='large-10 columns'])[2]")
    public WebElement text2;

    @FindBy(xpath = "(//*[@class='large-10 columns'])[3]")
    public WebElement text3;

    @FindBy(xpath = "(//*[text()='click here'])")
    public WebElement clickHere;


}
