package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;

public class WindowsPage {

    WebDriver driver;

    public WindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (xpath = "//a[text() = 'Click Here']")
    WebElement clickHereButton;

    @FindBy(xpath = "//h3[text() = 'New Window']")
    WebElement newWindowTitle;

    public void openSecondWindow(){
        clickHereButton.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(tabs);
        driver.switchTo().window(tabs.get(1));
        Assert.assertTrue(newWindowTitle.isDisplayed());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        Assert.assertTrue(clickHereButton.isDisplayed());

    }

}
