package com.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckDiscountedCodeTest {

    @Test
    public void discountCode_applies_true() {
        String code = CheckDiscountedCode.discountCode("F");
        Assertions.assertEquals(code, "OFFER_30");
    }

    @Test
    public void discountCode_no_offer() {
        String code = CheckDiscountedCode.discountCode("Z");
        Assertions.assertEquals(code, "");
    }
}
