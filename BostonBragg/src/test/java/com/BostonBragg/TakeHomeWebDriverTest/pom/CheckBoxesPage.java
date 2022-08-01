package com.BostonBragg.TakeHomeWebDriverTest.pom;

import com.BostonBragg.TakeHomeWebDriverTest.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxesPage {
    WebDriver driver;
    By checkbox1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
    By checkbox2 = By.xpath("//*[@id=\"checkboxes\"]/input[2]");

    public CheckBoxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckbox1() {
        DriverUtils.findElementWithWait(driver, checkbox1).click();
    }

    public void clickCheckbox2() {
        DriverUtils.findElementWithWait(driver, checkbox2).click();
    }

    public boolean checkbox1IsChecked() {
        return DriverUtils.findElementWithWait(driver, checkbox1).isSelected();
    }

    public boolean checkbox2IsChecked() {
        return DriverUtils.findElementWithWait(driver, checkbox2).isSelected();
    }
}
