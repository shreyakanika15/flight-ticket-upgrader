package com.io.validator.impl;

import com.io.util.Utility;
import com.io.validator.IValidator;

import java.util.List;

//Checks if the booked cabin is valid(one of Economy, Premium Economy,Business, First)
public class CabinValidator implements IValidator {

    private final static int BOOKED_CABIN_INDEX = 9;
    private final static List<String> VALID_CABIN = List.of("Economy", "Premium Economy", "Business", "First");

    @Override
    public boolean validate(final String[] records) {
        String bookedCabin = records[BOOKED_CABIN_INDEX];
        return !Utility.isStringEmptyOrNull(bookedCabin)
                && VALID_CABIN.contains(bookedCabin.trim());
    }

    @Override
    public String errorMessage() {
        return "Booked Cabin is InValid";
    }
}
