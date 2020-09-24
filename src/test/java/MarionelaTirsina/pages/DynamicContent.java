package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContent extends BasePage {
    @FindBy(xpath = "(//div[@class='large-2 columns'])[1]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]")
    public WebElement image1;

    @FindBy(xpath = "(//div[@class='large-2 columns'])[2]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]")
    public WebElement image2;

    @FindBy(xpath = "(//div[@class='large-2 columns'])[3]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]")
    public WebElement image3;

    @FindBy(xpath = "(//div[@class='large-10 columns'])[1]")
    public WebElement text1;

    @FindBy(xpath = "(//div[@class='large-10 columns'])[2]")
    public WebElement text2;
    @FindBy(xpath = "(//div[@class='large-10 columns'])[3]")
    public WebElement text3;

    @FindBy(xpath = "//a[contains(text(), 'click here')]")
    public WebElement clickHERE;

    @FindBy(xpath = "(//div[@class='large-2 columns'])[1]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]")
    public WebElement image4;

    @FindBy(xpath = "(//div[@class='large-2 columns'])[2]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]")
    public WebElement image5;

    @FindBy(xpath = "(//div[@class='large-2 columns'])[3]/img[starts-with(@src, '/img/avatars/Original-Facebook-Geek')]")
    public WebElement image6;

    @FindBy(xpath = "(//div[@class='large-10 columns'])[1]")
    public WebElement text4;

    @FindBy(xpath = "(//div[@class='large-10 columns'])[2]")
    public WebElement text5;

    @FindBy(xpath ="(//div[@class='large-10 columns'])[3]" )
    public WebElement text6;


}
