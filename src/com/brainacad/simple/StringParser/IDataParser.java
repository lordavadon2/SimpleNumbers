package com.brainacad.simple.StringParser;

public interface IDataParser {
    boolean tryParse() throws ValidationExaption;
    String getPrefix();
    String getDelimeter();
    Integer getPrefixValue();
    Integer getMaxNumber();
}
