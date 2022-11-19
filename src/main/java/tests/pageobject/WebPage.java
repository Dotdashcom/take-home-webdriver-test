package tests.pageobject;

import logging.Logging;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import static driver.Driver.getDriver;
import static java.lang.String.format;

public abstract class WebPage extends WebOperations implements Logging {

    protected WebPage() {
        getLogger().info(format("At page: %s", toString()));
        WebDriver driver = getDriver();
        ElementLocatorFactory decoratorFactory = new NamedElementLocatorFactory(driver);
        PageFactory.initElements(decoratorFactory, this);
    }

}
