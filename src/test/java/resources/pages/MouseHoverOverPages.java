package resources.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.utilities.BaseClass;

public class MouseHoverOverPages extends BaseClass {

    public MouseHoverOverPages() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div.example>div:nth-of-type(1)>img")
    WebElement firstImg;

    @FindBy(css="div.example>div:nth-of-type(1)>img")
    WebElement secImg;

    @FindBy(css="div.example>div:nth-of-type(1)>img")
    WebElement thirdImg;

    @FindBy(css="div.example>div:nth-of-type(1)>div>h5")
    WebElement firstText;

    @FindBy(css="div.example>div:nth-of-type(2)>div>h5")
    WebElement secText;

    @FindBy(css="div.example>div:nth-of-type(3)>div>h5")
    WebElement thirdText;

    public void hoverOnFirstImage() {
        Actions act = new Actions(driver);
        WebElement fir=driver.findElement(By.cssSelector("div.example>div:nth-of-type(1)>img"));
        act.moveToElement(fir).perform();
    }
    public void hoverOnSecondImage() {
        Actions act = new Actions(driver);
        WebElement fir=driver.findElement(By.cssSelector("div.example>div:nth-of-type(2)>img"));
        act.moveToElement(fir).perform();
    }
    public void hoverOnThirdImage() {
        Actions act = new Actions(driver);
        WebElement fir=driver.findElement(By.cssSelector("div.example>div:nth-of-type(3)>img"));
        act.moveToElement(fir).perform();
    }

    public String checkfirstText() {
        String text =firstText.getText();
        return text;
    }

    public String checkSecondText() {
        String text =secText.getText();
        return text;
    }
    public String checkThirdText() {
        String text =thirdText.getText();
        return text;
    }
}
