package com.io.validator.impl;

import com.io.validator.IValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.io.constant.Constants.COMMA;

public class MobilePhoneValidatorTest {

    IValidator validator;

    @BeforeEach
    public void init() {
        validator = new MobilePhoneValidator();
    }

    @Test
    public void isMobileNumberValid_results_true() {
        String test = "Abhishek, Kumar, ABC123, F, 2019-07-31, 2, 2019-05-21,abhishek@zzz.com, 9876543210, Economy";
        boolean result = validator.validate(test.split(COMMA));
        Assertions.assertTrue(result);
    }

    @Test
    public void isMobileNumberValid_results_false() {
        String test = "Abhishek, Kumar, ABC123, F, 2019-07-31, 2, 2019-05-21,abhishek@zzzcom, 129876543210, Economy1";
        boolean result = validator.validate(test.split(COMMA));
        Assertions.assertFalse(result);
    }

    @Test
    public void errorMessage() {
        Assertions.assertEquals(validator.errorMessage(), "Mobile Phone is InValid");
    }
}
