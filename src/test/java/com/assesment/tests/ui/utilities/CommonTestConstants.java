package com.assesment.tests.ui.utilities;

public class CommonTestConstants {

    /**
     *  Private constructor to prevent instantiation
     */
    private CommonTestConstants(){

    }
    private static final String VALID_USERNAME = ConfigReader.getProperty("username");
    private static final String VALID_PASSWORD = ConfigReader.getProperty("password");
    private static final String INVALID_USERNAME = "Test1234";
    private static final String INVALID_PASSWORD = "Toronto1234";
    private static final String VALID_USERNAME_ALL_CAPITAL = ConfigReader.getProperty("username").toUpperCase();
    private static final String VALID_PASSWORD_ALL_SMALL = ConfigReader.getProperty("password").toLowerCase();
    private static final String BLANK_USERNAME = "";
    private static final String BLANK_PASSWORD = "";


    public enum AccountCredential {
        // Valid Account Credential
        VALID_USERNAME_VALID_PASSWORD(VALID_USERNAME,VALID_PASSWORD),

        // Invalid Account Credentials
        USERNAME_VALID_PASSWORD_INVALID(VALID_USERNAME, INVALID_PASSWORD),
        USERNAME_INVALID_PASSWORD_VALID(INVALID_USERNAME, VALID_PASSWORD),
        USERNAME_INVALID_PASSWORD_INVALID(INVALID_USERNAME, INVALID_PASSWORD),
        USERNAME_AND_PASSWORD_VALID_BUT_USERNAME_UPPERCASE(VALID_USERNAME_ALL_CAPITAL, VALID_PASSWORD),
        USERNAME_AND_PASSWORD_VALID_BUT_PASSWORD_ALL_ARE_SMALL(VALID_USERNAME, VALID_PASSWORD_ALL_SMALL),
        USERNAME_VALID_PASSWORD_BLANK(VALID_USERNAME,BLANK_PASSWORD),
        BLANK_USERNAME_VALID_PASSWORD(BLANK_USERNAME,VALID_PASSWORD);
        private final String username;
        private final String password;

        AccountCredential(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return this.username;
        }

        public String getPassword() {
            return this.password;
        }
    }
}
