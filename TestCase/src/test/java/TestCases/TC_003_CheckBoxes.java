package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003_CheckBoxes extends BaseClass
{
    @Test (priority=3) //Test Case for Selecting and UnSelecting CheckBoxes
    public void CheckBox()
    {
        //Launching URL for CheckBoxes
        driver.get(BaseUrl+"checkboxes");
        //Inspecting WebElement for first CheckBox
        WebElement chkbox1= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        //Clicking on CheckBox1
        chkbox1.click();
        //storing checkBox result into A boolean variable
        boolean result= chkbox1.isSelected();
        //printing Checked CheckBox value
        System.out.println("CheckBox1 Expected result is True: "+chkbox1.isSelected());
        //Assrtions for check Box Checking and UnChecking
        Assert.assertEquals(result,true,"Assertion Msg Check Box Selected");
        //Unchecking CheckBox1
        chkbox1.click();
        //storing uncheckBox result into A boolean variable
        boolean result2=chkbox1.isSelected();
        //Printing Unchecked CheckBox Value
        System.out.println("CheckBox1 Expected result is false : "+chkbox1.isSelected());
        Assert.assertEquals(result2,false,"Assertion Msg CheckBox Unselected");
        //Inspecting WebElement for Second CheckBox

        WebElement chkbox2=driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]"));
        //Clicking on CheckBox2
        chkbox2.click();
        //storing checkBox result into A boolean variable
        boolean chkres=chkbox2.isSelected();
        System.out.println("CheckBox2 Expected result is false: "+chkbox2.isSelected());
        //Assertions for check Box Checking and UnChecking
        Assert.assertEquals(chkres,false);
        //Clicking on CheckBox2
        chkbox2.click();
        //Storing boolean value for checkBox
        boolean chkres2=chkbox2.isSelected();
        System.out.println("CheckBox2 Expected result is true : "+chkbox2.isSelected());
        //Assertion for after checking the check Box
        Assert.assertEquals(chkres2,true);
    }

}
