package model;

import model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.ArrayList;
public class JavascriptErrorPage extends BasePage {

    private static final String JS_ERROR_ENDPOINT = "javascript_error";

    private static final String[] javascriptErrorList = new String[]{
        "SyntaxError",
        "ReferenceError",
        "TypeError",
        "EvalError",
        "RangeError",
        "URIError",
        "InternalError",
        "AggregateError"};

    public JavascriptErrorPage(WebDriver driver) {
        super(driver);
    }

    public JavascriptErrorPage getJavascriptErrorPage() {
        getDriver(JS_ERROR_ENDPOINT);

        return this;
    }

    public boolean isJavascriptError() {
        List<LogEntry> logEntriesList = getDriver()
                .manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll();
        List<Boolean> isThereJSErrors = new ArrayList<>();

        for(LogEntry logEntry : logEntriesList) {
            for(String errorType : javascriptErrorList) {
                if(logEntry.getMessage().contains(errorType)) {
                    isThereJSErrors.add(true);
                }
            }
        }

        return isThereJSErrors.stream().allMatch(element->element == true);
    }

    public List<String> getJavascriptErrorsTextList() {
        List<LogEntry> logEntriesList = getDriver()
                .manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll();
        List<String> jsErrorsOnPage = new ArrayList<>();

        for(LogEntry logEntry : logEntriesList) {
            for(String errorType : javascriptErrorList) {
                if(logEntry.getMessage().contains(errorType)) {
                    jsErrorsOnPage.add(logEntry.getMessage());
                }
            }
        }

        return jsErrorsOnPage;
    }
}