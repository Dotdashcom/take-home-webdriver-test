package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.MouseHoverPageModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public class MouseHoverPageTest extends MainTest {

    MouseHoverPageModel page;

    private void init() {
        page = new MouseHoverPageModel(driver);
        driver.get(BASE_URL + MouseHoverPageModel.PAGE_URL);
    }

    @Test
    void WHEN_mouseover_image_THEN_text_displayed() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(MouseHoverPageModel.PAGE_URL));

        List<WebElement> figures = page.findFigures();
        // We expect 3 images/figures
        Assert.assertEquals(figures.size(), 3);

        ofNullable(figures).orElse(emptyList()).stream()
                .forEach(f -> {
                    // div with text should not be displayed
                    Assert.assertFalse(f.findElement(By.className("figcaption")).isDisplayed());

                    // Mover mouse over the image
                    new Actions(driver).moveToElement(f.findElement(By.tagName("img"))).perform();

                    // div with text should be displayed
                    Assert.assertTrue(f.findElement(By.className("figcaption")).isDisplayed());
                });
    }
}
