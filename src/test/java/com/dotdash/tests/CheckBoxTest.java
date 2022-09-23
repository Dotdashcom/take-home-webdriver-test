package com.dotdash.tests;

import com.dotdash.pages.CheckBoxPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxTest {


    @Test
    public void checkboxTest() {

        CheckBoxPage checkBoxPage = new CheckBoxPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("baseUrl"));
        List<WebElement> allCheckBoxes = checkBoxPage.checkboxes;

        for (int i = 0; i < allCheckBoxes.size(); i++) {
            if (!allCheckBoxes.get(i).isSelected()) {
                allCheckBoxes.get(i).click();
            }
            Assertions.assertTrue(allCheckBoxes.get(i).isSelected());
        }

        for (int i = 0; i < allCheckBoxes.size(); i++) {
            if (allCheckBoxes.get(i).isSelected()) {
                allCheckBoxes.get(i).click();
            }
            Assertions.assertFalse(allCheckBoxes.get(i).isSelected());
        }

    }

}
