package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.DynamicContentPage;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class DynamicContentTest extends UITest {

    public DynamicContentTest() { }

    @Test(description="Loads new texts and images on each page refresh")
    public void loadNewContent() {
        HashMap<String, String> content, newContent;
        DynamicContentPage dynamicContentPage = new DynamicContentPage(this);
        int testAttempts = 5;

        // Validate page loaded
        Assert.assertTrue(dynamicContentPage.isPageOpen(), "Page not open");

        // Validate content change
        while (testAttempts > 0) {
            // Collect content
            content = dynamicContentPage.getContent(false);
            dynamicContentPage.reloadPage();
            newContent = dynamicContentPage.getContent(false);

            // Validate content differs 100%
            Assert.assertNotEquals(newContent, content);
            testAttempts--;
        }
    }

    @Test(description="Loads partially new content (text and images) on each page refresh")
    public void loadPartiallyNewContent() {
        HashMap<String, String> content, newContent;
        DynamicContentPage dynamicContentPage = new DynamicContentPage(this);
        int attempts = 10;
        boolean difference;

        // Validate page loaded
        Assert.assertTrue(dynamicContentPage.isPageOpen(), "Page not open");

        // Validate content change
        while (attempts > 0) {
            difference = false;
            // Collect content
            content = dynamicContentPage.getContent(true);
            dynamicContentPage.reloadPage();
            newContent = dynamicContentPage.getContent(true);
            MapDifference<String, String> diff = Maps.difference(content, newContent);
            Map<String, MapDifference.ValueDifference<String>> entriesDiffering = diff.entriesDiffering();

            // Compare content
            if (entriesDiffering.size() > 0 || diff.entriesOnlyOnLeft().size() > 0 || diff.entriesOnlyOnRight().size() > 0)
                difference = true;
            // Validate content partially differs
            Assert.assertTrue(difference, "Content doesn't differ");
            attempts--;
        }
    }
}