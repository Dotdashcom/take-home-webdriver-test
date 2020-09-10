package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class JavaScriptAlertsPageSteps extends Functions {

    public static List<String> actualMessages;

    @When("user clicks on buttons and interacts with {string} {string} {string} alerts, enters {string}")
    public void user_clicks_on_buttons_and_interacts_with_alerts_enters(String alert, String confirm, String prompt, String textToPrompt) {

        actualMessages = new ArrayList<>();
        List<WebElement> alerts = javaScriptAlertsPage.alerts;

        for(WebElement a: alerts){
            if(a.getText().contains(alert)){
                click(a);
                driver.switchTo().alert().accept();

                actualMessages.add(javaScriptAlertsPage.resultMessage.getText());
            }else if(a.getText().contains(confirm)){
                click(a);
                driver.switchTo().alert().accept();

                actualMessages.add(javaScriptAlertsPage.resultMessage.getText());
            }else if(a.getText().contains(prompt)){
                click(a);
                driver.switchTo().alert().sendKeys(textToPrompt);
                driver.switchTo().alert().accept();

                actualMessages.add(javaScriptAlertsPage.resultMessage.getText());
            }
        }
    }

    @Then("user sees corresponding result messages")
    public void user_sees_corresponding_result_messages(io.cucumber.datatable.DataTable dataTable) {

        List<String>expectedMessages = dataTable.asList();

        Assert.assertEquals(expectedMessages, actualMessages);
    }
}
