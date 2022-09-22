package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DrangAndDropPage  extends BasePage {

    private final By coulmn_a = By.xpath("//*[@id='column-a']");
    private final By coulmn_b = By.xpath("//*[@id='column-b']");

    public DrangAndDropPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("dragAndDrop_url"));
    }

    public void dragAndDropFromAtoB(){

        WebElement fromBoxA = getDriver().findElement(coulmn_a);
        WebElement toBoxB = getDriver().findElement(coulmn_b);

        Actions dragAndDropAction = new Actions(getDriver());

        dragAndDropAction.dragAndDrop(fromBoxA, toBoxB).perform();

        if (fromBoxA.getText().equals("B")){
            Assert.assertTrue(fromBoxA.getText().equals("B"));
            Assert.assertTrue(toBoxB.getText().equals("B"));
            Log.info("Test have passed and We have dropped succesfully");
        }else{
            Log.info("Test have failed");
        }
    }
}
