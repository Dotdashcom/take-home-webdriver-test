package com.assesment.tests.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxesPage {

    WebDriver driver;

    public CheckBoxesPage(WebDriver driver){
        this.driver = driver;
    }
    public enum Using {
        CHECKBOX_1(By.xpath("//input[1]")),
        CHECKBOX_2(By.xpath("//input[2]"));

        private final By selector;

        Using(By selector) {
            this.selector = selector;
        }

        public By selector() {
            return this.selector;
        }
    }

    /**
     *  clicks on <b>checkbox 1</b>
     */
    public void clickOnCheckBox1(){
        driver.findElement(Using.CHECKBOX_1.selector()).click();
    }

    /**
     * Clicks on <b>checkbox 2</b>
     */
    public void clickOnCheckBox2(){
        driver.findElement(Using.CHECKBOX_2.selector()).click();
    }
    /**
     * Verifies if <b>checkbox 1</b> is clicked and selected
     * @return boolean true if checkbox is selected
     */
    public boolean isCheckBox1Selected(){
        return driver.findElement(Using.CHECKBOX_1.selector()).isSelected();
    }
    /**
     * Verifies if <b>checkbox 2</b> is clicked and selected
     * @return boolean true if checkbox is selected
     */
    public boolean isCheckBox2Selected(){
        return driver.findElement(Using.CHECKBOX_2.selector()).isSelected();
    }
}
