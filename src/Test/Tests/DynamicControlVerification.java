package Tests;

import Pages.BasePage;
import Pages.DynamicControlPage;
import Utils.Driver;
import Utils.HelpfulMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicControlVerification extends BasePage {
    DynamicControlPage dynamicControlPage = new DynamicControlPage();
    Faker faker = new Faker();

    @BeforeClass
    public void SetUp() {
        Driver.GetDriver().get("http://localhost:7080/dynamic_controls");
    }

    @Test
    public void TCDynamicControlVerification() {
        dynamicControlPage.ClickRemove();
        Assert.assertEquals(dynamicControlPage.Message(),
                "It's gone!");
        dynamicControlPage.ClickAdd();
        Assert.assertEquals(dynamicControlPage.Message(),
                "It's back!");
        HelpfulMethods.staticWait(5);
        dynamicControlPage.ClickEnable();
        Assert.assertEquals(dynamicControlPage.Message(),
                "It's enabled!");
        dynamicControlPage.SendTextAndDisable(faker.gameOfThrones().dragon());
        Assert.assertEquals(dynamicControlPage.Message(),
                "It's disabled!");
    }
}
