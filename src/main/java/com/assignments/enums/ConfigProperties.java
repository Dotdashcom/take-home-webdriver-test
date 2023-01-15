package com.assignments.enums;

/**
 * Enums to restrict the values used on Property files, without using enums there can be null
 * pointer exceptions happening because of typos.
 * <p>
 * Whenever a new value is added to property file, corresponding enum should be created here.
 */
public enum ConfigProperties {
  BROWSER,
  FAILEDSTEPSSCREENSHOTS,
  PASSEDSTEPSSCREENSHOTS,
  PASSWORD,
  RETRYFAILEDTESTS,
  SKIPPEDSTEPSSCREENSHOTS,
  URL,
  USERNAME;
}
