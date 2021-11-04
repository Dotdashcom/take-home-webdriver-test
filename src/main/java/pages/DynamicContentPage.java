package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class DynamicContentPage extends BasicPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]")
    WebElement content1;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]")
    WebElement content2;

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]")
    WebElement content3;

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/dynamic_content");
        PageFactory.initElements(driver, this);
    }

    public ArrayList<ArrayList<String>> getCurrentContents() {
        ArrayList<ArrayList<String>> contents = new ArrayList<>();
        WebElement[] contentElements = {content1, content2, content3};
        for (WebElement contentElement: contentElements) {
            String src = contentElement.findElement(By.xpath(".//img")).getAttribute("src");
            String text = contentElement.findElement(By.xpath(".//div[2]")).getText();
            ArrayList<String> array = new ArrayList<>();
            array.add(src);
            array.add(text);
            contents.add(array);
        }
        return contents;
    }

    public void refreshPage() {
        this.driver.navigate().refresh();
    }

    public void assertContents() {
        ArrayList<ArrayList<String>> before = this.getCurrentContents();
        this.refreshPage();
        ArrayList<ArrayList<String>> old = this.getCurrentContents();

        for (int i=0; i < before.size(); i ++) {
            if (!before.get(i).get(0).equals(old.get(i).get(0)) && !before.get(i).get(1).equals(old.get(i).get(1))) {
                return;
            }
        }
        Assert.fail();
    }
}
