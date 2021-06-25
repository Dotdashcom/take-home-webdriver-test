package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import pages.DragAndDropPage;
import pages.DropDownPage;
import utilities.EndPoints;

import java.util.List;

public class DropDown extends TestBase {


    @Test
    public void testDropDown() {
        DropDownPage dd = new DropDownPage();
        extentTest = extentReports.createTest("Drop - Down");
        extentTest.info("Navigate To Drop - Down Page");
        dd.navigateTo(EndPoints.DROPDOWN);
        extentTest.info("Select From Options");
        Select dropDown = new Select(dd.dropdown);
        List<WebElement> list = dropDown.getOptions();
        for(int i=0; i<list.size(); i++){
            dropDown.selectByIndex(i);
            Assert.assertTrue(list.get(i).isSelected());
            extentTest.info("Selected Options=>"+list.get(i).getText());
        }
        extentTest.info("Options are selected ");
        extentTest.pass("Drop-Down Test is Successful ");

    }
}
