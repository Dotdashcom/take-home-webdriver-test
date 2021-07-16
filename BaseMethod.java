package com.dotdash;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpHead;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class BaseMethod extends BasePage {

    public final int TIMEOUT = 5;

    /**
     * Wait until specified amount of seconds and verify element is displayed or not.
     * @param locator = locator of the Web element
     * @return
     */
    public WebElement findByVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    /**
     * Use this method to find all web elements.
     * @param locator = generic locator (i.e. locator that finds all rows/column)
     * @return number = the numbers elements located using the specific locator
     */
    public List<WebElement> findAllElementsByVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        List<WebElement> webElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)); //elements
        return webElements;
    }

    /**
     * Waits until a WebElement is clickable and then returns it.
     * @param locator = By locator
     * @return WebElement
     */
    public WebElement findByClickability(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return webElement;
    }


    /**
     * Wait until alert is displayed on page.
     */
    public void waitUntilAlertIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Method to test if file is downloadable."
     * @param webElement = File link
     * @param expectedContentType application/json etc.
     * @return true if file is downloadable, false otherwise
     */
    public boolean isFileDownloadable(WebElement webElement, String expectedContentType) {
        String link = webElement.getAttribute("href");
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(link);
        HttpResponse response = null;
        try {
            response = httpClient.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String contentType = response.getFirstHeader("Content-Type").getValue();
        int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());
        boolean result = contentType.equals(expectedContentType) && contentLength > 1;
        return result;
    }

}


