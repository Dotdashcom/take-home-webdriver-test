package Test;

import Utilities.DriverHelper;
import Main.DynamicContentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContentTest {

    DynamicContentPage dynamic =new DynamicContentPage();

    @Test
    public void CheckDynamicText1(){

        DriverHelper.getDriver().get("http://localhost:7080/dynamic_content");

        DriverHelper.getDriver().manage().window().maximize();


        String Text =  dynamic.DynamicText1.getText();


        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();



        String TextAfterRefresh =  dynamic.DynamicText1.getText();


        Assert.assertNotEquals(Text,TextAfterRefresh);

        DriverHelper.closeDriver();

    }

    @Test
    public void CheckDynamicText2(){

        DriverHelper.getDriver().get("http://localhost:7080/dynamic_content");

        DriverHelper.getDriver().manage().window().maximize();

        String Text =  dynamic.DynamicText2.getText();

        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();

        String TextAfterRefresh =  dynamic.DynamicText2.getText();

        Assert.assertNotEquals(Text,TextAfterRefresh);

        DriverHelper.closeDriver();

    }

    @Test
    public void CheckDynamicText3(){

        DriverHelper.getDriver().get("http://localhost:7080/dynamic_content");

        DriverHelper.getDriver().manage().window().maximize();

        String Text =  dynamic.DynamicText3.getText();

        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();

        String TextAfterRefresh =  dynamic.DynamicText3.getText();

        Assert.assertNotEquals(Text,TextAfterRefresh);

        DriverHelper.closeDriver();

    }

    @Test
    public void CheckDynamicPicture1() throws InterruptedException {

        DriverHelper.getDriver().get("http://localhost:7080/dynamic_content");

        DriverHelper.getDriver().manage().window().maximize();

        Thread.sleep(3000);

        String Text =  dynamic.DynamicPicture1.getAttribute("src");

        Thread.sleep(3000);

        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();

        String TextAfterRefresh =  dynamic.DynamicPicture1.getAttribute("src");

        Assert.assertNotEquals(Text,TextAfterRefresh);

        DriverHelper.closeDriver();

    }

    @Test
    public void CheckDynamicPicture2() throws InterruptedException {

        DriverHelper.getDriver().get("http://localhost:7080/dynamic_content");

        DriverHelper.getDriver().manage().window().maximize();

        String Text =  dynamic.DynamicPicture2.getAttribute("src");

        Thread.sleep(3000);

        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();

        String TextAfterRefresh =  dynamic.DynamicPicture2.getAttribute("src");

        Assert.assertNotEquals(Text,TextAfterRefresh);

        DriverHelper.closeDriver();

    }

    @Test
    public void CheckDynamicPicture3() throws InterruptedException {

        DriverHelper.getDriver().get("http://localhost:7080/dynamic_content");

        DriverHelper.getDriver().manage().window().maximize();

        String Text =  dynamic.DynamicPicture3.getAttribute("src");

        Thread.sleep(3000);

        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();

        DriverHelper.getDriver().navigate().refresh();

        String TextAfterRefresh =  dynamic.DynamicPicture3.getAttribute("src");

        Assert.assertNotEquals(Text,TextAfterRefresh);

        DriverHelper.closeDriver();
    }



}
