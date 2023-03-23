package steps;

import io.qameta.allure.Step;
import io.qameta.allure.selenide.LogType;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class JavascriptErrorSteps {


    @Step("Get console errors")
    public ArrayList getJsErrors() {

        List<String> jsErrors = new ArrayList<String>();
        Logs logs = getWebDriver().manage().logs();

        for (LogEntry entry : logs.get(String.valueOf(LogType.BROWSER))) {
            if ((String.valueOf(entry.getLevel())).equals("SEVERE")) {
                jsErrors.add(entry.getMessage());
            }
        }
        return (ArrayList) jsErrors;
    }

    @Step("Check if errors contain {text}")
    public Boolean isTextExistInError(String text){
        Boolean exist = false;
        ArrayList<String> errors = getJsErrors();

        for (String err : errors){
            if (err.contains(text)){
                exist = true;
                break;
            }
        }
        return exist;
    }

}
