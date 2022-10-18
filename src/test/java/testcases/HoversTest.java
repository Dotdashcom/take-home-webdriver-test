package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.HoversPage;
import org.junit.Test;

public class HoversTest extends BaseTest {

    public HoversTest(){
        super();
    }


    @Test
    public void HoverInEachImageAndVerifyingTheAdditionalInformation(){
        HoversPage hoversPage = new HoversPage(driver);

        hoversPage.assertOfAllUsersInformations();
    }
}
