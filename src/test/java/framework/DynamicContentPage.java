package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'click here')]")
    WebElement clickHere;

    public DynamicContentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean checkDynamicContent (WebDriver driver, int numberOfRefreshes) {
        ArrayList<String> results = new ArrayList<>();
        List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='large-10 columns']"));
        ArrayList<String> text1 = new ArrayList<String>();
        for (WebElement element : list1) {
            text1.add(getTextFromElement(driver, element));
        }
        System.out.println(text1);
        for (int i = 0; i < numberOfRefreshes; i++) {
            clickOnElement(driver, clickHere, "", "");
            List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='large-10 columns']"));
            ArrayList<String> text2 = new ArrayList<String>();
            for (WebElement element : list2) {
                text2.add(getTextFromElement(driver, element));
            }
            System.out.println(text2);
            if (text1.equals(text2)) {
                results.add("true");
            } else {
                results.add("false");
                System.out.println("Texts don't match");
            }
        }
        if (results.contains("true")) {
            return true;
        }
        return false;
    }
}
