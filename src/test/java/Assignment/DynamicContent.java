package Assignment;

import Pages.DynamicContentPage;
import Utilities.TestBase;
import Utilities.UI_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicContent extends TestBase {

        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);

    @Test
    public void dynamicContentTest(){


        driver.get(baseUrl + "/dynamic_content");



        List<String> listOfIconBeforeRefresh = UI_Methods.getTextFromAll(dynamicContentPage.listOfIcon,"getSrc");
        List<String> listOfDescriptionBeforeRefresh = UI_Methods.getTextFromAll(dynamicContentPage.listOfDescription,"getText");

        driver.navigate().refresh();

        boolean iconsChanged = listOfIconBeforeRefresh != UI_Methods.getTextFromAll(dynamicContentPage.listOfIcon , "getSrc");
        boolean descriptionChanged = listOfDescriptionBeforeRefresh != UI_Methods.getTextFromAll(dynamicContentPage.listOfDescription , "getText");

        Assert.assertTrue(iconsChanged || descriptionChanged , "content stayed the same after refresh");





    }

    }

