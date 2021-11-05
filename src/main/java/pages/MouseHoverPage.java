package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MouseHoverPage extends BasicPage {
    WebDriver driver;
    Actions actions;

    public MouseHoverPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/hovers");
        this.actions = new Actions(driver);
    }

    public void hoverImage(int index) {
        String imgXpath = String.format("//*[@id=\"content\"]/div/div[%d]/img", index);
        WebElement imgEle = this.driver.findElement(By.xpath(imgXpath));
        this.actions.moveToElement(imgEle).build().perform();
    }

    public void assertDisplayContent(int index) {
        String xpath = String.format("//*[@id=\"content\"]/div/div[%d]/div", index);
        Assert.assertTrue(this.driver.findElement(By.xpath(xpath)).isDisplayed());
    }
}
