package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage {

    private WebDriver driver;

    public MouseHoverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='example']//div[1]/img")
    private WebElement image1;

    @FindBy(xpath = "//div[@class='example']//div[2]/img")
    private WebElement image2;

    @FindBy(xpath = "//div[@class='example']//div[3]/img")
    private WebElement image3;

    @FindBy(xpath = "//h5[text()='name: user1']")
    private WebElement message1;

    @FindBy(xpath = "//h5[text()='name: user2']")
    private WebElement message2;

    @FindBy(xpath = "//h5[text()='name: user3']")
    private WebElement message3;

    public boolean moveToImage1() {
        Actions action = new Actions(driver);
        action.moveToElement(image1).build().perform();
        return message1.isDisplayed();
    }

    public boolean moveToImage2() {
        Actions action = new Actions(driver);
        action.moveToElement(image2).build().perform();
        return message2.isDisplayed();
    }

    public boolean moveToImage3() {
        Actions action = new Actions(driver);
        action.moveToElement(image3).build().perform();
        return message3.isDisplayed();
    }
}