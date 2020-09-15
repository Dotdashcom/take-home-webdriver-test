package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.WebDriverWrapper;

public class DynamicContentPage {

    WebDriver driver;

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='content']/div[1]/div[2]")
    WebElement textContentOne;

    @FindBy(xpath = "//*[@id='content']/div[1]/div[2]")
    WebElement textContentTwo;

    @FindBy(xpath = "//*[@id='content']/div[1]/div[2]")
    WebElement textContentThree;

    @FindBy(xpath ="//*[@id='content']/div[1]/div[1]/img")
    WebElement imageContentOne;

    @FindBy(xpath ="//*[@id='content']/div[1]/div[1]/img")
    WebElement imageContentTwo;

    @FindBy(xpath ="//*[@id='content']/div[1]/div[1]/img")
    WebElement imageContentThree;

    public void verifyTextChange(){
        String textOne = textContentOne.getText();
        String textTwo = textContentTwo.getText();
        String textThree = textContentThree.getText();
        driver.navigate().refresh();
        String refreshedTextOne = textContentOne.getText();
        String refreshedTextTwo = textContentTwo.getText();
        String refreshedTextThree = textContentThree.getText();
        Assert.assertNotEquals(textOne, refreshedTextOne);
        Assert.assertNotEquals(textTwo, refreshedTextTwo);
        Assert.assertNotEquals(textThree, refreshedTextThree);
    }

    public void verifyImageChange(){
        String imageSrcOne = imageContentOne.getAttribute("src");
        String imageSrcTwo = imageContentTwo.getAttribute("src");
        String imageSrcThree = imageContentThree.getAttribute("src");
        driver.navigate().refresh();
        String refreshedImageSrcOne = imageContentOne.getAttribute("src");
        String refreshedImageSrcTwo = imageContentTwo.getAttribute("src");
        String refreshedImageSrcThree = imageContentThree.getAttribute("src");
        Assert.assertNotEquals(imageSrcOne, refreshedImageSrcOne);
        Assert.assertNotEquals(imageSrcTwo, refreshedImageSrcTwo);
        Assert.assertNotEquals(imageSrcThree, refreshedImageSrcThree);

    }


}
