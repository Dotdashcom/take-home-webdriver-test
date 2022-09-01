package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MouseHoverPage {
    public MouseHoverPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[@class='figure'])[1]//img")
    public WebElement img1;
    @FindBy(xpath = "(//*[@class='figure'])[2]//img")
    public WebElement img2;
    @FindBy(xpath = "(//*[@class='figure'])[3]//img")
    public WebElement img3;
    @FindBy(xpath = "(//*[@class='figcaption'])[1]")
    public WebElement text1;
    @FindBy(xpath = "(//*[@class='figcaption'])[2]")
    public WebElement text2;
    @FindBy(xpath = "(//*[@class='figcaption'])[3]")
    public WebElement text3;


}
