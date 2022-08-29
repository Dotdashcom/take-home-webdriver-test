package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.ArrayList;

public class Test7DynamicContent extends chromedriver {

    @Test
    public void Test7DynamicContent() {
        String url = "http://localhost:7080/dynamic_content";
        driver.get(url);

        //xpath that captures all 3 content section
        By dynamicContent = By.xpath("//h3[text()='Dynamic Content']/following::div[@id='content']/div[@class='row']/div[@class='large-10 columns']");

        //puts together string array of all the content in first load
        ArrayList<String> elementTextsOne = new ArrayList<>();
        for(WebElement element : driver.findElements(dynamicContent)) {
            elementTextsOne.add(element.getText());
        };
        driver.navigate().refresh();

        //puts together string array of all the content in second load
        ArrayList<String> elementTextsTwo = new ArrayList<>();
        for(WebElement element : driver.findElements(dynamicContent)) {
            elementTextsTwo.add(element.getText());
        };
        driver.navigate().refresh();

        //puts together string array of all the content in third load
        ArrayList<String> elementTextsThree = new ArrayList<>();
        for(WebElement element : driver.findElements(dynamicContent)) {
            elementTextsThree.add(element.getText());
        };
        driver.navigate().refresh();

        //check that all arrays have the same number of elements
        Assert.assertEquals(elementTextsOne.size(),elementTextsTwo.size());
        Assert.assertEquals(elementTextsOne.size(),elementTextsThree.size());

        //check that each element has a different body of text from refresh to refresh
        for(int i = 0; i < elementTextsOne.size(); i++) {
            Assert.assertNotEquals(elementTextsOne.get(i),elementTextsTwo.get(i));
            Assert.assertNotEquals(elementTextsOne.get(i),elementTextsThree.get(i));
        }
    }

}