package framework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HoverPage {
    WebDriver driver;

    public HoverPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='content']/div/div[1]/img")
    WebElement hoverImageOne;

    @FindBy(xpath = "//*[@id='content']/div/div[2]/img")
    WebElement hoverImageTwo;

    @FindBy(xpath = "//*[@id='content']/div/div[3]/img")
    WebElement hoverImageThree;

    @FindBy (xpath = "//*[@id='content']/div/div[1]/div/h5")
    WebElement userOneName;

    @FindBy (xpath = "//*[@id='content']/div/div[2]/div/h5")
    WebElement userTwoName;

    @FindBy (xpath = "//*[@id='content']/div/div[3]/div/h5")
    WebElement userThreeName;

    @FindBy(xpath = "//*[@id='content']/div/div[1]/div/a")
    WebElement viewProfileLinkOne;

    @FindBy(xpath = "//*[@id='content']/div/div[2]/div/a")
    WebElement viewProfileLinkTwo;

    @FindBy(xpath = "//*[@id='content']/div/div[3]/div/a")
    WebElement viewProfileLinkThree;

    public void hoverOverImage(){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
        actions.moveToElement(element).perform();
        Assert.assertTrue(userOneName.isDisplayed());
        Assert.assertTrue(viewProfileLinkOne.isDisplayed());

        WebElement elementTwo = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"));
        actions.moveToElement(elementTwo).perform();
        Assert.assertTrue(userTwoName.isDisplayed());
        Assert.assertTrue(viewProfileLinkTwo.isDisplayed());

        WebElement elementThree = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"));
        actions.moveToElement(elementThree).perform();
        Assert.assertTrue(userThreeName.isDisplayed());
        Assert.assertTrue(viewProfileLinkThree.isDisplayed());
    }

}
