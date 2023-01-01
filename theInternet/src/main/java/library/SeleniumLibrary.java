package library;

import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class SeleniumLibrary {
    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void isElementSelected(WebElement element) {
        Boolean flag = element.isSelected();
        if (flag.equals(true))
            System.out.println("***********The WebElement is Selected ************");
        else
            System.out.println(" ***********The WebElement is not Selected ********");
    }

    public WebElement selectAnWebElementFromList(List<WebElement> webElements, String key) {
        for (WebElement webElement : webElements) {
            if (webElement.getText().equals(key))
                return webElement;
        }
        return null;  // if the list is empty
    }

}