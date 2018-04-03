package com.brainacad.simple.StringParser;

public class StringParser implements IStringParser {
    private String delimeter;
    private String prefix;
    private int prefixValue;
    private int maxNumber;
    private String userInput;
    private IInputValidator validator;
    private static String separator = " ";

    public StringParser(String userInput, IInputValidator validator) {
//        tryParse(input);
        this.validator = validator;
        this.userInput = userInput;
        this.maxNumber = 0;
        this.prefixValue = 0;
        this.prefix = "";
        this.delimeter = "";

    }

    @Override
    public boolean tryParse() throws ValidationExaption {
            validator.validate();
            String[] stringArray = userInput.split(separator);
            this.delimeter = new String(stringArray[0]);
            this.prefix = new String(stringArray[1]);
            this.prefixValue = new Integer(new String(stringArray[2]));
            this.maxNumber = new Integer(new String(stringArray[3]));

            return true;
    }

    @Override
    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public String getDelimeter() {
        return this.delimeter;
    }

    @Override
    public Integer getPrefixValue() {
        return this.prefixValue;
    }

    @Override
    public Integer getMaxNumber() {
        return this.maxNumber;
    }
}
