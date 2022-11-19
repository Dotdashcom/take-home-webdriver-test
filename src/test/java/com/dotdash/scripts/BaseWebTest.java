package com.dotdash.scripts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;
import junit.rules.UIErrorCollector;
import junit.runners.WebDriverRunner;
import logging.Logging;
import org.apache.commons.io.FileDeleteStrategy;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import tests.pageobject.WebPage;

import static driver.Driver.dispose;
import static driver.Driver.populateDriver;
import static java.nio.file.Files.createDirectories;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static properties.TestProperties.TEST_PROPERTIES;
import static utils.Lazy.lazily;
import static utils.Reflection.create;

@RunWith(WebDriverRunner.class)
public abstract class BaseWebTest<T extends WebPage> implements Logging {

    private static final String DOWNLOADS_FOLDER = "downloads";

    @Rule
    public UIErrorCollector errors = new UIErrorCollector();

    @Rule
    public ErrorCollector errorElements = new ErrorCollector();

    @Before
    public void setUp() {
        try {
            populateDriver(TEST_PROPERTIES.getBrowser());
            createDownloadsDirectory();
            getInitialPage().navigateTo();
        } catch (Exception e) {
            getLogger().error(e.getLocalizedMessage(), e);
        }
    }

    @After
    public void destroy() {
        dispose();
    }

    private final Supplier<T> initialPage = lazily(() -> create(getClass()));

    public T getInitialPage() {
        return initialPage.get();
    }

    protected <T> void checkThat(String validation, T actual, Matcher<T> expected) {
        this.errors.checkThat(validation, actual, expected);
    }

    protected <T> void checkThat(T actual, Matcher<T> expected) {
        this.errorElements.checkThat(actual, expected);
    }

    private String createDownloadsDirectory() {
        try {
            Path downloadPath = Paths.get(DOWNLOADS_FOLDER);
            if (downloadPath.toFile().exists()) {
                Files.walk(downloadPath)
                        .map(Path::toFile)
                        .filter(File::isFile)
                        .forEach(fileToDelete -> {
                            try {
                                FileDeleteStrategy.FORCE.delete(fileToDelete);
                            } catch (IOException e) {
                                getLogger().error("Could not delete file: %s", e.getLocalizedMessage());
                            }
                        });
                Files.deleteIfExists(downloadPath);
            }

            String dir = createDirectories(downloadPath).toAbsolutePath().toString();
            System.setProperty("wdm.targetPath", dir);
            return dir;
        } catch (IOException e) {
            getLogger().error("Could not delete & re-create downloads directory: " + e.getLocalizedMessage());
            return EMPTY;
        }
    }
}
