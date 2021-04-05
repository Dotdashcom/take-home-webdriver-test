package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_005_DragAndDrop extends BaseClass
{
    @Test (priority=5) //Test Case for Drag and Drop
    public void DragAndDrop()
    {
        //Launching Drag and Drop URL
        driver.get(BaseUrl+"drag_and_drop");
        //Inspecting dragging WebElement
        WebElement Source=driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        String DragbleTxt=Source.getText();
        //Getting text from Source
        System.out.println(DragbleTxt);
        //inspecting droppable webElement
        WebElement Target=driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
        //Getting text from Target
        String DropblTxt=Target.getText();
        System.out.println(DropblTxt);
        // Using Actions Class for Mouse Drag And Drop Action
        Actions act=new Actions(driver);

        //dragging source Element A to Target Element B
        act.dragAndDrop(Source, Target).build().perform();
        //Assertion for After Drag and Drop
        Assert.assertEquals(DragbleTxt,"A");
        System.out.println("A is switched with B");
        //dragging Target Eleemnt B to Source Element A
        act.dragAndDrop(Target,Source).build().perform();
        //Assertion for Target to source
        Assert.assertEquals(DropblTxt,"B");
        System.out.println("B is switched with A");
    }
}
