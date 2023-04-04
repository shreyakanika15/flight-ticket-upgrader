package com.io.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilityTest {

    @Test
    public void isStringEmptyOrNull_results_false() {
        String test = "sample";
        boolean result = Utility.isStringEmptyOrNull(test);
        Assertions.assertFalse(result);
    }

    @Test
    public void isStringBlankOrNull_results_true() {
        String test = "";
        boolean result = Utility.isStringEmptyOrNull(test);
        Assertions.assertTrue(result);
    }

}
