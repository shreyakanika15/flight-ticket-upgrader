package com.io.validator.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.io.constant.Constants.COMMA;

public class CabinValidatorTest {

    CabinValidator cabinValidator;

    @BeforeEach
    public void init() {
        cabinValidator = new CabinValidator();
    }

    @Test
    public void isCabinValid_results_true() {
        String test = "Abhishek, Kumar, ABC123, F, 2019-07-31, 2, 2019-05-21,abhishek@zzz.com, 9876543210, Economy";
        boolean result = cabinValidator.validate(test.split(COMMA));
        Assertions.assertTrue(result);
    }

    @Test
    public void isCabinValid_results_false() {
        String test = "Abhishek, Kumar, ABC123, F, 2019-07-31, 2, 2019-05-21,abhishek@zzz.com, 9876543210, Economy1";
        boolean result = cabinValidator.validate(test.split(COMMA));
        Assertions.assertFalse(result);
    }

    @Test
    public void errorMessage() {
        Assertions.assertEquals(cabinValidator.errorMessage(), "Booked Cabin is InValid");
    }
}
