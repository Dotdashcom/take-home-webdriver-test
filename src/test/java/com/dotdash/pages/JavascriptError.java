package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.logging.LogEntry;
import tests.pageobject.WebPage;

@Url("/javascript_error")
public class JavascriptError extends WebPage {

    public boolean isLogPresent(String logValue) {
        LogEntry entry = getLogs().getAll().stream().filter(log -> log.toString().contains(logValue)).findAny().orElse(null);
        return entry != null;
    }
}
