package Tests;

import Pages.BasePage;
import Pages.iFramePage;
import Utils.Driver;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrameVerification extends BasePage {
    iFramePage iFramePage = new iFramePage();
    Faker faker = new Faker();
    @BeforeClass
    public void SetUp(){
        Driver.GetDriver().get("http://localhost:7080/iframe");
    }

@Test
    public void TC1IframeVerification(){
        String text = faker.backToTheFuture().quote();
        iFramePage.SwitchFrame(text);

}
}
