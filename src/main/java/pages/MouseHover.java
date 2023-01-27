package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MouseHover {
    private WebDriver driver;
    private SoftAssert softAssert;

    public MouseHover(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='figure']")
    private List<WebElement> imgs;

    @FindBy(tagName = "h5")
    private List<WebElement> imgsText;

    public void checkIfMouseHover()  {
        navigateToMouseHoverPage();
        Actions actions = new Actions(driver);
        for (int i = 0; i < imgs.size(); i++) {
            actions.moveToElement(imgs.get(i)).perform();
            softAssert.assertEquals(imgsText.get(i).getText().trim(),"name: user"+(i+1),"Text is not displayed correctly, when mouse hover");
        }
    }

    private void navigateToMouseHoverPage(){
        driver.get(ConfigReader.getProperty("url")+"/hovers ");
    }



}
