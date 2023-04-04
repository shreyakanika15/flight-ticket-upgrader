package com.io.util;

import static com.io.constant.Constants.EMPTY_STR;

//utility class for reusing functionalities
public final class Utility {
    private Utility() {
    }

    public static boolean isStringEmptyOrNull(final String string) {
        return string == null
                || string.trim().equals(EMPTY_STR);
    }
}
