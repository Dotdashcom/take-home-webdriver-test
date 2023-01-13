package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDownPage extends Base {
    WebDriver driver;

    By dropDown = By.xpath(readValue("dropDownPage.dropDownXp"));

    public void selectOption(String optionDesired) {
        WebElement list = driver.findElement(dropDown);
        List<WebElement> options = list.findElements(By.xpath("//option"));
        for (WebElement option : options) {
            if (optionDesired.equals(option.getText())) {
                option.click();
            }
        }
    }

    public String getTextDropDown() {
        WebElement list = driver.findElement(dropDown);
        List<WebElement> options = list.findElements(By.xpath("//option"));
        String text = "";
        for (WebElement option : options) {
            if (option.isSelected()) {
                text = option.getText();
                break;
            }
        }
        return text;
    }

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }
}
