package com.dotDash.utils;

import org.apache.log4j.Logger;

import com.dotDash.utils.listeners.LogListener;

/**
 * The Class has all Logging related utilities.
 *
 * @author Seb Geb
 */
public class LoggerUtil {

	/** The logger. */
	private static Logger logger = Logger.getLogger(LogListener.class);

	/**
	 * Logs info
	 * 
	 * @author Seb Geb
	 * @param message the message
	 */
	public static void log(String message) {
		logger.info(message);
	}

	/**
	 * Gets the logger.
	 * 
	 * @author Seb Geb
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}
}
