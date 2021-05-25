package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DynamicContent extends POBase {
    public void refreshVerify(){
        //String row1Text = getElement(By.xpath("(//div[@class='large-10 columns'])[1]")).getText();
        //BrowserUtil.GetDriver().navigate().refresh();
        for (int i = 0; i < 2; i++){
            String row1TextBefore = getElement(By.xpath("(//div[@class='large-10 columns'])[1]")).getText();
            BrowserUtil.GetDriver().navigate().refresh();
            String row1TextAfter = getElement(By.xpath("(//div[@class='large-10 columns'])[1]")).getText();
            Assert.assertNotEquals(row1TextAfter, row1TextBefore);
            System.out.println(row1TextBefore);
            System.out.println(row1TextAfter);
        }
    }
}
