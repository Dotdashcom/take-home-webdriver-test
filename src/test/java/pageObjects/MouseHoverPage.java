package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class MouseHoverPage extends BaseClass {

    public MouseHoverPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement hoversPageHeader;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/img")
    public WebElement userOneImage;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/img")
    public WebElement userTwoImage;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[3]/img")
    public WebElement userThreeImage;

    @FindBy(xpath = "//div[@class='example']/div[1]/div[@class='figcaption']/h5")
    public WebElement userOneCaption;

    @FindBy(xpath = "//div[@class='example']/div[2]/div[@class='figcaption']/h5")
    public WebElement userTwoCaption;

    @FindBy(xpath = "//div[@class='example']/div[3]/div[@class='figcaption']/h5")
    public WebElement userThreeCaption;
}
