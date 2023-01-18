package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DropDownPage extends BasePage {

    // PAGE INITIALIZATION:
    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By DROP_DOWN = By.cssSelector("select[id='dropdown'] option");

    // WEB ELEMENTS:
    private List<WebElement> getDropDown() {
        wait.until(ExpectedConditions.presenceOfElementLocated(DROP_DOWN));
        return driver.findElements(DROP_DOWN);
    }


    // METHODS:
    public void doDropDownSelect(String option) {
        List<WebElement> listOfOptions = getDropDown();
        for (WebElement op : listOfOptions) {
            if (op.getText().contains(option)) {
                log.info("User selects the '" + option + "' from drop down menu. ");
                op.click();
            }
        }
    }

    public boolean getDropDownSelectedTxt(String option) {
        List<WebElement> listOfOptions = getDropDown();
        String txt = "";
        for (WebElement op : listOfOptions) {
            if (op.isSelected()) {
                log.info("User receives the '" + option + "' from selected drop down menu. ");
                txt = op.getText();
                System.out.println(" =====> " + txt + " <===== ");
                break;
            }
        }
        return txt.equals(option);
    }
}


