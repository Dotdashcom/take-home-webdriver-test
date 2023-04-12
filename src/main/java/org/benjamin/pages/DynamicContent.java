package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DynamicContent {
    public List<Content>[] refreshAndGetContents(boolean isStatic) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/dynamic_content" + (isStatic ? "?with_content=static" : ""));

        List<Content> beforeRefresh = getContent(driver);
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        List<Content> afterRefresh = getContent(driver);

        driver.close();

        // sort according to the paragraph
        beforeRefresh.sort(Comparator.comparing(a -> a.paragraph));
        afterRefresh.sort(Comparator.comparing(a -> a.paragraph));

        List<Content>[] result = new List[]{beforeRefresh, afterRefresh};
        return result;
    }

    List<Content> getContent(WebDriver driver) {
        List<WebElement> rows = driver.findElements(By.cssSelector("#content>.row"));
        List<Content> allContents = rows.stream().map((e) -> {
            WebElement image = e.findElement(By.cssSelector("img"));
            String imageAddr = image.getAttribute("src");

            WebElement textBox = e.findElement(By.cssSelector("div:nth-child(2)"));
            String paragraph = textBox.getText();

            return new Content(imageAddr, paragraph);
        }).collect(Collectors.toList());

        return allContents;
    }

    public static class Content {
        private String imgAddr;
        private String paragraph;

        public Content(String imgAddr, String paragraph) {
            this.imgAddr = imgAddr;
            this.paragraph = paragraph;
        }

        public boolean equals(Content another) {
            return imgAddr.equals(another.imgAddr) && paragraph.equals(another.paragraph);
        }
    }
}
