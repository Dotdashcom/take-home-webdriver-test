package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import io.cucumber.java.AfterStep;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CheckBoxTest {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/checkboxes");

    }

    @After
    public void teardown() {

    Driver.closeDriver();
    }

    @Test
    public void checkBox1Test() {

        //here I have the locators of the check boxes.
        WebElement checkBox1 = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2 = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][2]"));

        //I have to click checkBox2 fist because by default box2 is already selected
        //if i don't click box2 first when i click box1 both boxes will be selected
        checkBox2.click();
        checkBox1.click();

        //In here I checked only box1 selected
        Assert.assertTrue(checkBox1.isSelected());

           }

    @Test
    public void checkBox2Test(){

        WebElement checkBox2 = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][2]"));

        //I didn't click any box because by default box2 was selected already
        //that's why I only checked box2 is selected or not.
        Assert.assertTrue(checkBox2.isSelected());

    }

    @Test
    public  void checkBox1_2Test(){

        WebElement checkBox1 = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2 = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox'][2]"));

        //Because by default box2 was selected I only clicked box1
        checkBox1.click();

        //In here after only i clicked box1 checked both boxes selected or not.
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());







    }

}
