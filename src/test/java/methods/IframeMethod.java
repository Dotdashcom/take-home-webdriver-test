package methods;

import model.IframePage;

public class IframeMethod extends GeneralTestMethod{

    private final String IframeURL = "http://localhost:7080/iframe";
    IframePage iframePage;

    public void startIframeTest(String text) {
        driver.get(IframeURL);
        iframePage = new IframePage(driver);
        typeIn(text);
    }

    public void typeIn(String text) {
        iframePage.fileComponent().click();
        iframePage.newDocComponent().click();
        driver.switchTo().frame("mce_0_ifr");
        iframePage.textboxComponent().sendKeys(text);
    }

    public String getContent() {
        return iframePage.textboxComponent().getText();
    }

}
