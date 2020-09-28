package pageobject;

import base.EndPointPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DynamicContentPage extends BasePage {

    @FindBy(xpath = "//div[@class='large-10 column']")
    private List<WebElement> contents;

    public DynamicContentPage(WebDriver driver) {
        super(driver, EndPointPath.DYNAMIC_CONTENT);

    }

    public boolean refreshAndVerifyAllContentChanged(int refreshTime) {
        for (int count=0; count < refreshTime; count++) {
            List<WebElement> elements = contents;
            driver.navigate().refresh();
            List<WebElement> elements2 = contents;
            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).equals(elements.get(i)))
                    return false;
            }
        }
        return true;

    }

    public boolean refreshAndVerifySomeContentChanged(int refreshTime) {
        super.accessUrl(EndPointPath.DYNAMIC_CONTENT_STATIC);
        for (int count=0; count < refreshTime; count++) {
            List<WebElement> elements = contents;
            driver.navigate().refresh();
            List<WebElement> elements2 = contents;
            for (int i = 0; i < elements.size(); i++) {
                if (i<elements.size()-1) {
                    if (!elements.get(i).equals(elements.get(i)))
                        return false;
                }
                else {
                    if (elements.get(i).equals(elements.get(i)))
                        return false;
                }

            }
        }
        return true;

    }


}
