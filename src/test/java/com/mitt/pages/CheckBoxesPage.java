package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckBoxesPage extends BasePage {

    private final By checkBox1_xpath = By.xpath("//*[@id='checkboxes']/input[1]");
    private final By checkBox2_xpath = By.xpath("//*[@id='checkboxes']/input[1]");

    public CheckBoxesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("checkbox_url"));
    }

    public void click_one_checkBox(String checkbox){

        if (checkbox.equals("checkbox1")) {
            Log.info("checkbox1 is clicking");
            Assert.assertEquals(true, isElementPresent(checkBox1_xpath));
            if (!isSelected(checkBox1_xpath)) getDriver().findElement(checkBox1_xpath).click();
        }
        if (checkbox.equals("checkbox2")) {
            Log.info("checkbox2 is clicking");
            Assert.assertEquals(true, isElementPresent(checkBox2_xpath));
            if (!isSelected(checkBox1_xpath)) getDriver().findElement(checkBox2_xpath).click();
        }

    }

    public void click_both_checkBox(){

        Assert.assertEquals(true, isElementPresent(checkBox1_xpath));
        if (!isSelected(checkBox1_xpath)) {
            Log.info("checkbox1 is clicking");
            getDriver().findElement(checkBox1_xpath).click();
        }

        Assert.assertEquals(true, isElementPresent(checkBox2_xpath));
        if (!isSelected(checkBox1_xpath)){
            Log.info("checkbox2 is clicking");
            getDriver().findElement(checkBox2_xpath).click();
        }

    }

    public void uncheckBox(String checkbox){

        if (checkbox.equals("checkbox1")) {
            Log.info("Unchecking is checkbox1");
            Assert.assertEquals(true, isElementPresent(checkBox1_xpath));
            if (isSelected(checkBox1_xpath)) getDriver().findElement(checkBox1_xpath).click();
        }
        if (checkbox.equals("checkbox2")) {
            Log.info("Unchecking is checkbox2");
            Assert.assertEquals(true, isElementPresent(checkBox2_xpath));
            if (isSelected(checkBox1_xpath)) getDriver().findElement(checkBox2_xpath).click();
        }

    }

    public boolean isSelected(String checkbox) {

        if (checkbox.equals("checkbox1")) {
            Log.info("Checkbox1 is selected ->"+ isSelected(checkBox1_xpath));
            return isSelected(checkBox1_xpath);
        }

        if (checkbox.equals("checkbox2")) {
            Log.info("Checkbox2 is selected ->"+ isSelected(checkBox1_xpath));
            return isSelected(checkBox1_xpath);
        }

        return false;
    }
}
