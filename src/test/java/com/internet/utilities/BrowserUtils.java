package com.internet.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BrowserUtils {
    public static List<String> getTextFromWebElements(List<WebElement> elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText());
            }
        }
        return textValues;
    }

    public static boolean checkIfAllExist (List<WebElement> elements, String text){
        return BrowserUtils.getTextFromWebElements(elements).stream().allMatch(t ->t.contains(text));
    }
    public static boolean checkIfAnyExist(List<WebElement> elements, String text){
        return BrowserUtils.getTextFromWebElements(elements).stream().anyMatch(t ->t.contains(text));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(ConfigurationReader.getProperty("browser")), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver(ConfigurationReader.getProperty("browser"))).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver(ConfigurationReader.getProperty("browser"))).executeScript("arguments[0].click();", element);
    }

    public static void removeAttributeJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver(ConfigurationReader.getProperty("browser"))).executeScript("arguments[0].removeAttribute('readonly','readonly');", element);   
    }

    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver(ConfigurationReader.getProperty("browser"))).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static String getScreenshot(String name) {
        name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
        String path = "";
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
        } else {
            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
        }

        System.out.println("OS name: " + System.getProperty("os.name"));
        System.out.println("Screenshot is here: " + path);
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver(ConfigurationReader.getProperty("browser"));
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static void writeTheFile(String newVal) {
        try {
            FileWriter myWriter = new FileWriter("tempWeb.txt");
            myWriter.write(String.valueOf(newVal));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String readTheFile() {
        String memNum ="";
        try {
            File myObj = new File("tempWeb.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                memNum=data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return memNum;
    }
}
