package net.serenity.showcase.utils;

import net.serenity.showcase.utils.Constants.WaitingTime;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * This class contains utility methods, which can be used in Steps and Pages
 * files.
 *
 * @author Manish Lalwani
 */
public class Util {

    private static Logger logger = Logger.getLogger(Util.class);
    /**
     * Properties files variable declarations
     */
    private static Properties orHomePage;
    /**
     * Method to get name of current method for log4j
     */
    private static Method m;
    private static StringBuffer finalUrl;

    static {
        try {
            m = Throwable.class.getDeclaredMethod("getStackTraceElement", int.class);
            m.setAccessible(true);

        } catch (Exception e) {
            logger.info(e);
        }
    }

    /**
     * Constructor.
     *
     * @param driver WebDriver
     */
    public Util(final WebDriver driver) {
        logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
    }

    /**
     * @param waitTime How many seconds should pause
     */
    public static void pause(final WaitingTime waitTime) {
        logger.debug(Util.getMethodName(0) + "(): waitTime= " + waitTime);

        switch (waitTime) {
            case SHORT:
                waitFor(Constants.WAIT_FOR_2000MS);
                break;
            case MEDIUM:
                waitFor(Constants.WAIT_FOR_4000MS);
                break;
            case LONG:
                waitFor(Constants.WAIT_FOR_7000MS);
                break;
            default:
                logger.debug(Util.getMethodName(0) + "(): ERROR: invalid waiting time(" + waitTime + "). Please enter one of SHORT, MEDIUM, or LONG");
                break;
        }
    }

    /**
     * @param waitTime How many seconds should pause
     */
    private static void waitFor(final int waitTime) {
        logger.debug(Util.getMethodName(0) + "(): waitTime= " + waitTime);
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static FileInputStream brandConfigFile(final String page) throws FileNotFoundException {
        return (new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//" + page + ".properties"));
    }

    public static void initializing() throws IOException {
        loadHomePageProperties();
    }

    private static void loadHomePageProperties() throws IOException {
        logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
        setOrHomePage(new Properties());
        getOrHomePage().load(brandConfigFile(Constants.HOMEPAGE));
    }

    public static Properties getOrHomePage() {
        return orHomePage;
    }

    public static void setOrHomePage(Properties orHomePage) {
        Util.orHomePage = orHomePage;
    }

    public static StringBuffer getFinalUrl() {
        return finalUrl;
    }

    public static void setFinalUrl(StringBuffer finalUrl) {
        Util.finalUrl = finalUrl;
    }


    /**
     * This method returns a method name.
     *
     * @param depth depth in the call stack (0 means current method, 1 means call
     *              method, ...)
     * @return method name
     */
    public static String getMethodName(final int depth) {
        try {
            StackTraceElement element = (StackTraceElement) m.invoke(new Throwable(), depth + 1);
            return element.getMethodName();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


