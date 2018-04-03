package com.brainacad.simple;

import com.brainacad.simple.SimpleNumber.Primes;
import com.brainacad.simple.StringParser.DataParser;
import com.brainacad.simple.StringParser.IDataParser;
import com.brainacad.simple.StringParser.InputValidator;
import com.brainacad.simple.StringParser.ValidationExaption;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Для растчета и вывода резульатов простых чисел введите данные формата:");
        System.out.println("\"delimeter prefix значение_установки_префикса максимальное_значение_поиска\"");
        System.out.println("Пример:\"; # 3 10000\"");
        String userInput = new Scanner(System.in).nextLine();
        IDataParser parser = new DataParser(userInput, new InputValidator(userInput));
        Primes primes = new Primes(parser);
        try{
            parser.tryParse();
            System.out.println(primes.getSimpleNumber());
            primes.writeToFile(primes.getSimpleNumber());
        }
        catch (ValidationExaption exc){
            System.out.println("Ошибка валидации: " + exc.getValidationErrorInfo());
        }
    }
}
