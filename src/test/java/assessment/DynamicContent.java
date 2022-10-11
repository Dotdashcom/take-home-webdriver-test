package assessment;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicContentPage;
import util.Driver;

import java.util.List;

public class DynamicContent extends Driver{

    DynamicContentPage page = new DynamicContentPage(Driver.getDriver());

    @Test
    public void dynamic_content() {
        Driver.getDriver().get("http://localhost:7080/dynamic_content");

        List<String> iconSrcBefore = page.getTextFromAll(page.icons , "getSrc");
        List<String> descriptionTextBefore = page.getTextFromAll(page.description , "getText");

        Driver.getDriver().navigate().refresh();

//        List<String> iconSrcAfter = page.getTextFromAll(page.icons , "getSrc");
//        List<String> descriptionTextAfter = page.getTextFromAll(page.description , "geText");

        boolean iconsChanged = iconSrcBefore != page.getTextFromAll(page.icons , "getSrc");
        boolean descriptionChanged = descriptionTextBefore != page.getTextFromAll(page.description , "getText");

        Assert.assertTrue(iconsChanged || descriptionChanged , "content stayed the same after refresh");
    }
}
