package pageobject;

import base.EndPointPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoverPage extends BasePage {

    @FindBy(xpath = "//div[@class='figure']")
    private List<WebElement> images ;
    @FindBy(xpath = "//div[@class='figcaption']/h5")
    private List<WebElement> names ;



    public HoverPage(WebDriver driver) {
        super(driver, EndPointPath.MOUSE_HOVER);

    }

    public boolean verifyTextInAllImages(List<String> listNames) {
        Actions actions = new Actions(driver);
        String profileName;
        for (int i=0; i<images.size(); i++) {
            actions.moveToElement(images.get(i)).build().perform();
            //Utilities.explicitWaitByWebElementvisibilityOfElementLocated(driver, driver.findElements(viewProfile).get(i));
            profileName = names.get(i).getText();
            System.out.println(profileName);
            if (!profileName.equals(listNames.get(i))) {
                return false;
            }
        }
        return true;
    }



}
