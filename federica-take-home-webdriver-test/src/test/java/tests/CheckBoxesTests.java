package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;
import utils.ConfigurationReader;
import utils.Driver;
import utils.TestBase;

import java.util.concurrent.TimeUnit;

public class CheckBoxesTests extends TestBase {
    CheckBoxesPage checkBoxesPage=new CheckBoxesPage();
    String url="/checkboxes";
    @BeforeTest
    public void setUrl(){
        Driver.setUp(url);
    }


    @Test
    public void checkBoxesSelected(){
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
        if(!checkBoxesPage.boxOne.isSelected()){
            checkBoxesPage.boxOne.click();
        }
        if (!checkBoxesPage.boxTwo.isSelected()){
            checkBoxesPage.boxTwo.click();
        }
        Assert.assertTrue(checkBoxesPage.boxOne.isSelected()&&checkBoxesPage.boxTwo.isSelected());

    }
}
