package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class MultipleWindow {

    public MultipleWindow(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Multiple Windows")
    WebElement multipleWindow;

    @FindBy(linkText = "Click Here")
    WebElement clickhere;

    @FindBy(tagName = "h3")
    WebElement newWindowText;

    public void clickHere(WebDriver driver){
        multipleWindow.click();
        clickhere.click();

        Set<String> allHandles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        // to switch driver to the basicControls page
        for (String handle : allHandles ) {

            if (!currentHandle.equals(handle)){
                driver.switchTo().window(handle);

                break;
            }
        }

        String expectedText = "New Window";

        Assert.assertTrue(newWindowText.getText().equals(expectedText));
    }

}
