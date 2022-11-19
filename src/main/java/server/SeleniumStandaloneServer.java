package server;

import logging.Logging;
import org.openqa.grid.internal.utils.configuration.StandaloneConfiguration;
import org.openqa.selenium.remote.server.SeleniumServer;

import static java.lang.Runtime.getRuntime;
import static java.lang.String.format;

public enum SeleniumStandaloneServer implements Logging {
    SERVER;

    private SeleniumServer seleniumServer;

    private boolean notStarted = true;

    /**
     * Starts the {@link SeleniumServer} using the standalone configuration
     */
    public void start() {
        if (notStarted) {
            seleniumServer = new SeleniumServer(new StandaloneConfiguration());
            getRuntime().addShutdownHook(new Thread(this::stop));
            getLogger().info("Starting Selenium Server...\n");
            seleniumServer.boot();
            getLogger().info(format("Selenium Server started on port %d...", seleniumServer.getRealPort()));
            notStarted = false;
        }
    }

    /**
     * Stops the {@link SeleniumServer}
     */
    public void stop() {
        getLogger().info("Shutting down local Selenium Stand Alone Server...");
        seleniumServer.stop();
        notStarted = true;
    }

}
