package com.io.validator;

public interface IValidator {

    boolean validate(final String[] records);

    String errorMessage();
}

