package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage extends BasePage {

    public CheckboxesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectCheckboxes (WebDriver driver) {
        List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement element : list) {
            clickOnElement(driver, element, "Success: Clicked on checkbox",
                    "Failed: Unable to click on checkbox");
            if (isElementSelected(driver, element)) {
                clickOnElement(driver, element, "Success: Unchecked the checkbox",
                        "Failed: Unable to uncheck the  checkbox");
            }
        }
    }
}
