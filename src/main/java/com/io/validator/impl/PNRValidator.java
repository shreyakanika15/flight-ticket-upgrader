package com.io.validator.impl;

import com.io.util.Utility;
import com.io.validator.IValidator;

import java.util.regex.Pattern;

//Checks PNR is valid having 6 characters and Is alphanumeric
public class PNRValidator implements IValidator {

    private final static int PNR_INDEX = 2;
    private final static int PNR_LENGTH = 6;
    private final static String ALPHA_NUMERIC_REGEX = "^[a-zA-Z0-9]*$";
    private final static Pattern PNR_PATTERN = Pattern.compile(ALPHA_NUMERIC_REGEX);

    @Override
    public boolean validate(final String[] records) {
        String pnr = records[PNR_INDEX];
        return !Utility.isStringEmptyOrNull(pnr)
                && pnr.trim().length() == PNR_LENGTH
                && PNR_PATTERN.matcher(pnr.trim()).matches();
    }

    @Override
    public String errorMessage() {
        return "PNR is InValid";
    }
}
