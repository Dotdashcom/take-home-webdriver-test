package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class DynamicContent extends Constants{
    @Test
    public void dynamicContent1() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_content");
        List<WebElement> contentList1 = driver.findElements(By.xpath("//*[@id='content' and @class='large-10 columns large-centered']//div[@class='large-10 columns']"));
        List<String> text1 = new ArrayList<>();
        for (WebElement x : contentList1) text1.add(x.getText().trim());

        driver.navigate().refresh();
        List<WebElement> contentList2 = driver.findElements(By.xpath("//*[@id='content' and @class='large-10 columns large-centered']//div[@class='large-10 columns']"));
        List<String> text2 = new ArrayList<String>();
        for (WebElement x : contentList2) text2.add(x.getText().trim());

        driver.navigate().refresh();
        List<WebElement> contentList3 = driver.findElements(By.xpath("//*[@id='content' and @class='large-10 columns large-centered']//div[@class='large-10 columns']"));
        List<String> text3 = new ArrayList<String>();
        for (WebElement x : contentList3) text3.add(x.getText().trim());

        int len1 = text1.size();
        int len2 = text2.size();
        int len3 = text3.size();

        int len = Math.min(Math.min(len1, len2), len3);

        for (int i = 0; i < len; i++) {
            sa.assertNotEquals(text1.get(i), text2.get(i));
            sa.assertNotEquals(text3.get(i), text2.get(i));
            sa.assertNotEquals(text1.get(i), text3.get(i));
        }
        sa.assertAll();
    }




}
