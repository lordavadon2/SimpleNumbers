package com.brainacad.simple.StringParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator implements IInputValidator {

    private String data;

    public InputValidator(String data){
        this.data = data;
    }

    private void checkInputFormat() throws ValidationExaption {
        Pattern pattern = Pattern.compile("^[^A-Za-z0-9][\\s][^A-Za-z0-9][\\s][0-9][\\s]([0-9])+$");
        Matcher matcher = pattern.matcher(this.data);
        if (!matcher.matches()) {throw new ValidationExaption("Заданная строка не соответствует формату...");}
    }

    @Override
    public boolean validate() throws ValidationExaption {
        checkInputFormat();
        return false;
    }
}
