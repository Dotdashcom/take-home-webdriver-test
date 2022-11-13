package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.JavaScriptErrorPageModel;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public class JavaScriptErrorPageTest extends MainTest {

    public static final String EXPECTED_JAVASCRIPT_ERROR_TEXT = "Cannot read properties of undefined (reading 'xyz')";
    JavaScriptErrorPageModel page;

    private void init() {
        page = new JavaScriptErrorPageModel(driver);
        driver.get(BASE_URL + JavaScriptErrorPageModel.PAGE_URL);
    }

    @Test
    void WHEN_load_page_THEN_javascript_error_occurs() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(JavaScriptErrorPageModel.PAGE_URL));

        List<LogEntry> logEntries = page.getLogEntries().getAll();

        // Some log entries might not have messages
        List<LogEntry> logEntriesWithMessages = ofNullable(logEntries).orElse(emptyList()).stream()
                .filter(l -> l.getMessage() != null && !l.getMessage().isEmpty())
                .collect(Collectors.toList());
        // Make sure logEntriesWithMessages is not empty
        Assert.assertTrue(logEntriesWithMessages.size() > 0);

        // Now we can check for our specific JavaScript error message
        Long count = logEntriesWithMessages.stream()
                        .filter(l -> l.getMessage().contains(EXPECTED_JAVASCRIPT_ERROR_TEXT)).count();
        Assert.assertTrue(count > 0, "Cannot find expected JavaScript error.");
    }
}
