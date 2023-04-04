package com.io.validator.impl;

import com.io.util.Utility;
import com.io.validator.IValidator;

import java.util.regex.Pattern;

//Check if the Email-id is valid
public class EmailValidator implements IValidator {

    private final static String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private final static Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private final static int EMAIL_INDEX = 7;

    @Override
    public boolean validate(final String[] records) {
        String email = records[EMAIL_INDEX];
        return !Utility.isStringEmptyOrNull(email)
                && EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    @Override
    public String errorMessage() {
        return "Email is InValid";
    }
}
