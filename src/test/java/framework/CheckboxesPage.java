package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage extends BasePage {

    @FindBy (xpath = "(//input[contains(@type, 'checkbox')])[1]")
    WebElement checkbox1;

    @FindBy (xpath = "(//input[contains(@type, 'checkbox')])[2]")
    WebElement checkbox2;

    public CheckboxesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectCheckboxes (WebDriver driver) {
        List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement element : list) {
            clickOnElement(driver, element, "Success: Clicked on checkbox",
                    "Failed: Unable to click on checkbox");
        }
    }

    public boolean isChecked (WebDriver driver) {
        if (isElementSelected(driver, checkbox1)) {
            System.out.println("Checkbox1 is checked");
            return true;
        }
        return false;
    }

    public boolean isUnchecked (WebDriver driver) {
        if (isElementSelected(driver, checkbox1)) {
            System.out.println("Checkbox2 is unchecked");
            return true;
        }
        return false;
    }
}
