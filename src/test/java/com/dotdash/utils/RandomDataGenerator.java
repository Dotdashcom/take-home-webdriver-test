package com.dotdash.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public final class RandomDataGenerator {

    private RandomDataGenerator() {
    }

    public static String getRandomEmail() {
        return randomAlphabetic(8) + "@" + randomAlphabetic(8) + ".com";
    }

    public static String getRandomPassword() {
        String upperCaseLetters = random(2, 65, 90, true, true);
        String lowerCaseLetters = random(2, 97, 122, true, true);
        String numbers = randomNumeric(2);
        String specialChar = random(2, 33, 47, false, false);
        String totalChars = randomAlphanumeric(2);
        String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
                .concat(numbers)
                .concat(specialChar)
                .concat(totalChars);
        List<Character> pwdChars = combinedChars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(pwdChars);
        String password = pwdChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return password;
    }
}
