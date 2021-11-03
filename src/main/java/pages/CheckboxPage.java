package pages;

import constants.CheckBoxStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;


public class CheckboxPage extends BasicPage {
    WebDriver driver;

    HashMap<Integer, WebElement> checkBoxHashMap;

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/checkboxes");
        this.checkBoxHashMap = new HashMap<>();
    }

    public WebElement findCheckBox(int index) {
        WebElement checkbox = this.checkBoxHashMap.get(index);
        if (checkbox != null) {
            return checkbox;
        }
        try {
            By by = By.xpath(String.format("//*[@id=\"checkboxes\"]/input[%d]", index));
            checkbox = this.driver.findElement(by);
            this.checkBoxHashMap.put(index, checkbox);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        return checkbox;
    }

    public void clickCheckBox(int index) {
        this.findCheckBox(index).click();
    }

    public void resetCheckBoxTo(int index, CheckBoxStatus status) {
        WebElement checkBox = this.findCheckBox(index);
        boolean isChecked = status == CheckBoxStatus.CHECKED;
        if (checkBox.isSelected() != isChecked) {
            checkBox.click();
        }
    }

    public void assertCheckboxResult(int index, CheckBoxStatus status) {
        WebElement checkBox = this.findCheckBox(index);
        boolean isChecked = status == CheckBoxStatus.CHECKED;
        Assert.assertEquals(checkBox.isSelected(), isChecked);
    }
}
