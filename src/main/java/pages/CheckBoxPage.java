package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.util.List;

public class CheckBoxPage {

    private final By checkbobHeader = By.xpath("//h3[text()='Checkboxes']");
    private final By checkbox = By.xpath("//input[@type='checkbox']");

    public CheckBoxPage navigatetoCheckBoxpage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/checkboxes");
        return this;
    }

    public boolean checkboxHeader() {
        return UtilitiesManager.FindElement(checkbobHeader).isDisplayed();
    }

    public boolean checkBoxVerification() {

        boolean result = false;
        List<WebElement> checkboxes = UtilitiesManager.FindElements(checkbox);
        for (WebElement ele : checkboxes) {
            if (ele.isSelected()) {
                ele.click();
                result = true;
                System.out.println("Checkbox unchecked");
            } else if (!ele.isSelected()) {
                ele.click();
                result = true;
                System.out.println("Checkbox checked");
            } else {
                result = false;
                System.out.println("Checkbox Not interactable");
            }
        }
        return result;
    }

}
