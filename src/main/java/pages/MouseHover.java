package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class MouseHover {
    public MouseHover(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='figure']")
    public List<WebElement> images;
    @FindBy(xpath = "//div[@class='figure']//img")
    public List<WebElement> texts;

//    @FindBy(tagName = "//h5[.='name: user1']")
//    public WebElement text1;
//    @FindBy(tagName = "//h5[.='name: user2']")
//    public WebElement text2;
//    @FindBy(tagName = "//h5[.='name: user3']")
//    public WebElement text3;


    public String hoverImage(WebDriver driver, int i) {
        Actions actions = new Actions(driver);

        actions.moveToElement(images.get(i)).perform();
        String text = images.get(i).getText();
        return text;

//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='figcaption']")));


    }

}

