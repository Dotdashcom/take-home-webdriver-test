package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DynamicContent {

    public DynamicContent(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Dynamic Content")
    WebElement dynamicContent;
    @FindBy(xpath ="//div[@class='large-10 columns']")
    WebElement contents;

    public void isChanged(WebDriver driver){
        dynamicContent.click();

            String text = contents.getText();
            driver.navigate().refresh();
            String text2 = contents.getText();

            Assert.assertFalse(text.equals(text2));

    }
}
