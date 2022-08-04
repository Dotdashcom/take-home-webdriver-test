package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Test3CheckBoxes extends GenericTest {

    @Test
    public void Test3CheckBoxes() {
        String url = "http://localhost:7080/checkboxes";
        driver.get(url);

        //get checbox web elements
        WebElement checkBoxOne = driver.findElement(By.xpath("//div[@class='example']/descendant::input[1]"));
        WebElement checkBoxTwo = driver.findElement(By.xpath("//div[@class='example']/descendant::input[2]"));

        //check initial state
        Boolean checkBoxOneInitial = checkBoxOne.isSelected();
        Boolean checkBoxTwoInitial = checkBoxTwo.isSelected();
        Assert.assertFalse(checkBoxOneInitial);
        Assert.assertTrue(checkBoxTwoInitial);

        //toggle both checkboxes
        checkBoxOne.click();
        checkBoxTwo.click();

        //recheck there state after interaction
        Boolean checkBoxOneResult = checkBoxOne.isSelected();
        Boolean checkBoxTwoResult = checkBoxTwo.isSelected();
        Assert.assertTrue(checkBoxOneResult);
        Assert.assertFalse(checkBoxTwoResult);
    }

}