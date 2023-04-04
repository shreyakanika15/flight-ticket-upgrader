package com.io.validator.impl;

import com.io.util.Utility;
import com.io.validator.IValidator;

// Checks if the mobile number given is valid
public class MobilePhoneValidator implements IValidator {

    private final static int MOBILE_PHONE_INDEX = 8;

    @Override
    public boolean validate(final String[] records) {
        String mobileNumber = records[MOBILE_PHONE_INDEX];
        return !Utility.isStringEmptyOrNull(mobileNumber)
                && mobileNumber.trim().length() == 10;
    }

    @Override
    public String errorMessage() {
        return "Mobile Phone is InValid";
    }
}
