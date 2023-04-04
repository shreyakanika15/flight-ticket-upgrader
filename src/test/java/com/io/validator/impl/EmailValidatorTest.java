package com.io.validator.impl;

import com.io.validator.IValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.io.constant.Constants.COMMA;

public class EmailValidatorTest {
    IValidator validator;

    @BeforeEach
    public void init() {
        validator = new EmailValidator();
    }

    @Test
    public void isEmailIdValid_results_true() {
        String test = "Abhishek, Kumar, ABC123, F, 2019-07-31, 2, 2019-05-21,abhishek@zzz.com, 9876543210, Economy";
        boolean result = validator.validate(test.split(COMMA));
        Assertions.assertTrue(result);
    }

    @Test
    public void isEmailIdValid_results_false() {
        String test = "Abhishek, Kumar, ABC123, F, 2019-07-31, 2, 2019-05-21,abhishek@zzzcom, 9876543210, Economy1";
        boolean result = validator.validate(test.split(COMMA));
        Assertions.assertFalse(result);
    }

    @Test
    public void errorMessage() {
        Assertions.assertEquals(validator.errorMessage(), "Email is InValid");
    }
}
