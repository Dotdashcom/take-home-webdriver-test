package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;
import utils.ConfigurationReader;
import utils.Driver;
import utils.TestBase;

import java.util.concurrent.TimeUnit;

public class CheckBoxesTests extends TestBase {
    CheckBoxesPage checkBoxesPage=new CheckBoxesPage();
    String url="/checkboxes";

    @Test
    public void checkBoxesSelected(){
        Driver.setUp(url);
        if(checkBoxesPage.boxOne.isSelected()){
            checkBoxesPage.boxOne.click();
        }
        if(checkBoxesPage.boxTwo.isSelected()){
            checkBoxesPage.boxTwo.click();
        }
        Assert.assertTrue(!checkBoxesPage.boxOne.isSelected()&&!checkBoxesPage.boxOne.isSelected());

    }

    @Test
    public void checkBoxesNonSelected(){
        Driver.setUp(url);
        if(!checkBoxesPage.boxOne.isSelected()){
            checkBoxesPage.boxOne.click();
        }
        if (!checkBoxesPage.boxTwo.isSelected()){
            checkBoxesPage.boxTwo.click();
        }
        Assert.assertTrue(checkBoxesPage.boxOne.isSelected()&&checkBoxesPage.boxTwo.isSelected());

    }
}
