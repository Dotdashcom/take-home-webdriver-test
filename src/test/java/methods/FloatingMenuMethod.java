package methods;

import model.FloatingMenuPage;

public class FloatingMenuMethod extends GeneralTestMethod{

    private final String floatingMenuURL = "http://localhost:7080/floating_menu";
    FloatingMenuPage floatingMenuPage;

    public void startFloatingMenuTest() {
        driver.get(floatingMenuURL);
        floatingMenuPage = new FloatingMenuPage(driver);
        scrollPage();
    }

    public boolean isMenuDisplayed() {
        return floatingMenuPage.floatingMenu().isDisplayed();
    }

    public void scrollPage() {
        floatingMenuPage.javascriptExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        Thread.sleep(2000);
    }
}
