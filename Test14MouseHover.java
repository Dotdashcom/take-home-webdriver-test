package com.dotdash;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Test14MouseHover extends BaseMethod {
    @Test
    public void hoversTest() {
        driver.get("http://localhost:7080/hovers");

        By user1Loc = By.className("figure");
        WebElement img1 = findByVisibility(user1Loc);
        Actions builder = new Actions(driver);
        builder.moveToElement(img1).build().perform();

        WebElement user1Elem = findByVisibility(By.cssSelector(".figcaption>h5"));
        Assert.assertEquals("name: user1", user1Elem.getText());

        //TODO HW: hover over img 2 and img3 due Mon
    }
}
