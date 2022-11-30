package com.dotdash.utils;

import com.dotdash.utils.commons.PropertiesManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScriptReader {

    private static final Logger logger = Logger.getLogger(PropertiesManager.class.getName());

    public static String readScriptFile() {
        String script = null;
        try {
            script = new String(Files.readAllBytes(Paths.get("src/main/resources/dragdropscript.js")));
        } catch (IOException ioException) {
            logger.log(Level.SEVERE, "Script file not found", ioException);
        }
        return script;
    }
}
