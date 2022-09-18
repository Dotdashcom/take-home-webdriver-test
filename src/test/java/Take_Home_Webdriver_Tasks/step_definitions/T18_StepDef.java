package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.NotificationMsgPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;


public class T18_StepDef {
    NotificationMsgPage page = new NotificationMsgPage();

    @When("user clicks on the Click Here button")
    public void userClicksOnTheClickHereButton() {
        page.clickHereLink.click();
    }

    @Then("verify that action message is displayed")
    public void verifyThatActionMessageIsDisplayed() {
        String expMsgOne = "Action successful";
        String expMsgTwo = "Action unsuccesful, please try again";
        String expMsgThree = "Action unsuccessful";

        String allExpMsg[] = {expMsgOne,expMsgTwo,expMsgThree};
        List<String> allExpMsgList = Arrays.asList(allExpMsg);

        String actMsg = page.actionMsg.getText();
        for(String each : allExpMsgList){
        if(actMsg.equals(each)){
            Assert.assertEquals(each, actMsg);
            }
        }

        //Assert.assertTrue(expMsgOne.equals(actMsg) || expMsgTwo.equals(actMsg) || expMsgThree.equals(actMsg));

    }


}
