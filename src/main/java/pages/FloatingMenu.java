package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class FloatingMenu {
    private WebDriver driver;
    private SoftAssert softAssert;

    public FloatingMenu(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='scroll large-10 columns large-centered']")
    private WebElement paragraph;

    @FindBy(xpath = "//div[@id='menu']/ul/li")
    private List<WebElement> headerElements;

    public void testFloatingMenu()  {
        navigateToFloatingMenuPage();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        for (int i = 0; i < headerElements.size(); i++) {
            softAssert.assertTrue(headerElements.get(i).isDisplayed(),"Header element is not displayed");
        }


    }
    private void navigateToFloatingMenuPage(){
        driver.get(ConfigReader.getProperty("url")+"/floating_menu ");
    }
}