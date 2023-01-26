package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class checkBox extends TestBase{

    @FindBy (xpath = "//form[@id= \"checkboxes\"]/input[1]")
    WebElement check_box1;

    @FindBy (xpath = "//form[@id=\"checkboxes\"]/input[2]")
    WebElement check_box2;

    @FindBy(id = "checkboxes")
    List<WebElement> main;

    public checkBox() {
        PageFactory.initElements(driver, this);
    }

    public void verifyCheckboxesSelection() throws InterruptedException {

        Boolean box_1_before = check_box1.isSelected();
        Boolean box_2_before = check_box2.isSelected();
//        System.out.println("box_1_before: "+box_1_before);
//        System.out.println("box_2_before: "+box_2_before);
        check_box1.click();
        check_box2.click();
        Boolean box_1_after = check_box1.isSelected();
        Boolean box_2_after = check_box2.isSelected();
//        System.out.println("box_1_after: "+box_1_after);
//        System.out.println("box_2_after: "+box_2_after);
        if(box_1_before.equals(box_1_after)) {
            Assert.assertTrue(false);
        }else
            Assert.assertTrue(true);
        if(box_2_before.equals(box_2_after)) {
            Assert.assertTrue(false);
        }else
            Assert.assertTrue(true);
    }



}
