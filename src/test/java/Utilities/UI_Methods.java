package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class UI_Methods {

    public static List<String> getTextFromAll(List<WebElement> elements, String type) throws RuntimeException {
        List<String> allTexts;
        switch (type) {
            case "getText":
                allTexts = new ArrayList<>();
                try {
                    for (WebElement description : elements) {
                        allTexts.add(description.getText());
                    }
                } catch (IndexOutOfBoundsException e) {
                    Assert.fail("getTextFromAll method has List (allTexts) that is empty, check locator");
                }
                break;
            case "getSrc":
                allTexts = new ArrayList<>();
                try {
                    for (WebElement icon : elements) {
                        allTexts.add(icon.getAttribute("href"));
                    }
                } catch (IndexOutOfBoundsException e) {
                    Assert.fail("getTextFromAll method has List (allTexts) that is empty, check locator");
                }
                break;
            default:
                throw new RuntimeException("wrong type provided to getTextFromAll");
        }
        if (allTexts.size() == 0) {
            Assert.fail("getTextFromAll method failed, locator is invalid and the list this method created is empty");
        }
        return allTexts;

    }


}
