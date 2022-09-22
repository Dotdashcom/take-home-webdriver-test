package net.serenity.showcase.steps;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.AfterScenario;

import net.serenity.showcase.utils.Util;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.Thucydides;


/**
 * author :  Manish Lalwani
 * Acceptance Test Suite Driver
 */

@SuppressWarnings("deprecation")
public class AcceptanceTestSuite extends SerenityStories {

    private static Logger logger = Logger.getLogger(AcceptanceTestSuite.class);

    private String exception;

    /**
     * Constructor.
     *
     * @throws Exception
     */
    public AcceptanceTestSuite() throws Exception {
        super();
        logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
        Util.initializing();
    }
}
