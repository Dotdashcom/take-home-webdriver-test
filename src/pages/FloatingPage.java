import org.openqa.selenium.*;

public class FloatingPage extends BasePage {
    private String path = "/floating_menu";

    private String homeButtonXpath = "//div[@id='menu']//li[1]";
    private String newsButtonXpath = "//div[@id='menu']//li[2]";
    private String contactButtonXpath = "//div[@id='menu']//li[3]";
    private String aboutButtonXpath = "//div[@id='menu']//li[4]";

    FloatingPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public boolean floatingMenuVisibleCheck() {
        return (elementInView(homeButtonXpath) &&
                elementInView(newsButtonXpath) &&
                elementInView(contactButtonXpath) &&
                elementInView(aboutButtonXpath));
    }

    public boolean elementInView(String elementXpathToCheck) {
        WebElement homebutton = driver.findElement(By.xpath(elementXpathToCheck));

        String jsGetElementByXpath =
                "function getElementByXpath(path) {" +
                "return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "}";
        String jsElementInViewport =
                "function isElementInViewport (el) {" +
                "var rect = el.getBoundingClientRect();" +
                "console.log(rect);" +
                "console.log(window.innerHeight || document.documentElement.clientHeight);" +
                "console.log(window.innerWidth || document.documentElement.clientWidth);" +
                "return (" +
                "(rect.top + rect.height) >= 0 && rect.left >= 0 &&" + // Made it top + height because its top is slightly cut off but still visible
                "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&" +
                "rect.right <= (window.innerWidth || document.documentElement.clientWidth)" +
                ");" +
                "}";
        String jsVerifyElement =
                "return isElementInViewport(getElementByXpath(\"" + elementXpathToCheck + "\"));";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean isVisible = (Boolean) js.executeScript(jsGetElementByXpath + jsElementInViewport + jsVerifyElement);

        Point location = homebutton.getLocation();

        return isVisible;
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        // Putting a pause to give the float menus a chance to catch up
        try {
            Thread.sleep(500);
        }catch (InterruptedException e) {
            System.out.println("Interrupted sleep.");
        }
    }

}
