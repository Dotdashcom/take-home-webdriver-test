package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver)
    {
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/drag_and_drop");
    }

    @FindBy(id = "column-a")
    private WebElement box1;

    @FindBy(id = "column-b")
    private WebElement box2;


    public void dragAndDropBox1ToBox2(){

        String textBox1Before = box1.getText();
        String textBox2Before = box2.getText();

        Actions actions = new Actions(driver);

        actions.dragAndDrop(box1,box2).build().perform();

        wait.until(ExpectedConditions.textToBe(By.id("column-a"), textBox2Before));

        String textBox1After = box1.getText();
        String textBox2After = box2.getText();

        Assert.assertNotEquals(textBox1Before,textBox1After);
        Assert.assertNotEquals(textBox2Before,textBox2After);


    }

}
