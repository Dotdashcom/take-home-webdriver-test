package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class DynamicControlPage extends BasePage {

    private final By removeButton_xpath = By.xpath("(//*[contains(text(),'Remove')])[3]");
    private final By checkBox_xpath = By.xpath("//*[@id='checkbox']");
    private final By addButton_xpath = By.xpath("(//*[contains(text(),'Add')])[2]");
    private final By enableButton_xpath = By.xpath("(//*[contains(text(),'Enable')])[3]");
    private final By disableButton_xpath = By.xpath("(//*[contains(text(),'Disable')])[2]");
    private final By enableDisableTextBox_xpath = By.xpath("//*[@id='input-example']/input");


    public DynamicControlPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("dynamic_controls_url"));
        wait(10000);
    }

    public void validateRemoveButton(){

        if (findElement(removeButton_xpath) !=null )  findElement(removeButton_xpath).click();

        Assert.assertEquals(pageSourceVerify("It's gone!"),true);

        wait(1000);
        Assert.assertEquals(isElementPresent(removeButton_xpath), false);

        wait(1000);
        Assert.assertEquals(isElementPresent(checkBox_xpath), false);

    }

    public void validateAddButton(){

        if (findElement(addButton_xpath) !=null )  findElement(addButton_xpath).click();

        Assert.assertEquals(pageSourceVerify("It's back!"),true);

        wait(1000);
        Assert.assertEquals(isElementPresent(addButton_xpath), false);

        wait(1000);
        Assert.assertEquals(isElementPresent(checkBox_xpath), true);

    }

    public void validateEnableButton(){

        if (findElement(enableButton_xpath) !=null )  findElement(enableButton_xpath).click();

        Assert.assertEquals(pageSourceVerify("It's enabled!"),true);

        wait(1000);
        Assert.assertEquals(isElementPresent(enableButton_xpath), false);

        wait(1000);
        Assert.assertEquals(isElementPresent(enableDisableTextBox_xpath), true);

    }

    public void validateDiableButton(){

        if (findElement(enableButton_xpath) !=null )  findElement(enableButton_xpath).click();

        if (findElement(disableButton_xpath) !=null )  findElement(disableButton_xpath).click();

        Assert.assertEquals(pageSourceVerify("It's disabled!"),true);

        wait(10000);
        Assert.assertEquals(isElementPresent(disableButton_xpath), false);

        wait(10000);
        Assert.assertEquals(findElement(enableDisableTextBox_xpath).isEnabled(), false);

    }

}
