package io.github.moudjames23.paycard4j.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidator {


    private static final String URL_REGEX =
            "^https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}" +
                    "\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    private URLValidator() {
    }


    public static boolean isValid(String url) {
        return URL_PATTERN.matcher(url).matches();
    }
}
