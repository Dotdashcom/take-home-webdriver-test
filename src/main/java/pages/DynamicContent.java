package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DynamicContent {
    private WebDriver driver;
    private SoftAssert softAssert;

    public DynamicContent(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//div[@class='large-10 columns'])[3]")
    private WebElement dynamicText;


    public void verifyDynamicText(){
        getDynamicTextUrl();
        ConfigReader.setProperty("text",dynamicText.getText());
        driver.navigate().refresh();
        softAssert.assertTrue(!ConfigReader.getProperty("text").equalsIgnoreCase(dynamicText.getText()),"Text did not change");
    }

    private void getDynamicTextUrl(){
        driver.get(ConfigReader.getProperty("url")+"/dynamic_content ");

    }
}
