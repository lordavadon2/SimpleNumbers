package com.brainacad.simple.StringParser;

public class ValidationExaption extends Exception {
    private String validationErrorInfo;

    public ValidationExaption(String validationErrorInfo) {
        super();
        this.validationErrorInfo = validationErrorInfo;
    }

    public String getValidationErrorInfo() {
        return validationErrorInfo;
    }
}
