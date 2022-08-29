package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Test3CheckBoxes extends chromedriver {

    @Test
    public void Test3CheckBoxes() {
        String url = "http://localhost:7080/checkboxes";
        driver.get(url);

        WebElement checkBoxOne = driver.findElement(By.xpath("//div[@class='example']/descendant::input[1]"));
        WebElement checkBoxTwo = driver.findElement(By.xpath("//div[@class='example']/descendant::input[2]"));
        boolean checkBoxOneInitial = checkBoxOne.isSelected();
        boolean checkBoxTwoInitial = checkBoxTwo.isSelected();
        Assert.assertFalse(checkBoxOneInitial);
        Assert.assertTrue(checkBoxTwoInitial);
        checkBoxOne.click();
        checkBoxTwo.click();
        boolean checkBoxOneResult = checkBoxOne.isSelected();
        boolean checkBoxTwoResult = checkBoxTwo.isSelected();
        Assert.assertTrue(checkBoxOneResult);
        Assert.assertFalse(checkBoxTwoResult);
    }

}