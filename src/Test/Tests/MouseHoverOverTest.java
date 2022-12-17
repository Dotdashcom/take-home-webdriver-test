package Tests;

import Pages.BasePage;
import Pages.MouseHoverPage;
import Utils.Driver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseHoverOverTest extends BasePage {
    MouseHoverPage hoverPage = new MouseHoverPage();
    @BeforeClass
    public void SetUp(){
        Driver.GetDriver().get("http://localhost:7080/hovers");
    }

    @Test
    public void TC1MouseHoverOverProfileVerification(){
        String images = hoverPage.HoverOverImages();
        System.out.println(images + " ");
    }
}
