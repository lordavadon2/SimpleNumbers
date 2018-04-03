package com.brainacad.simple;

import com.brainacad.simple.SimpleNumber.Primes;
import com.brainacad.simple.StringParser.*;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Для растчета и вывода резульатов простых чисел введите данные формата:");
        System.out.println("\"Разделитель префикс_перед_числом " +
                "значение_для_уставки_префикса максимальное_значение_поиска\"");
        System.out.println("Пример:\"; # 3 10000\"");
        String userInput = new Scanner(System.in).nextLine();
        IStringParser parser = new StringParser(userInput, new InputValidator(userInput));
        Primes primesNumber = new Primes(parser);
        try{
            parser.tryParse();
            primesNumber.getPrimesFromParser();
            System.out.println(primesNumber.getPrimes());
            primesNumber.writePrimesToFile(primesNumber.getPrimes());
        }
        catch (ValidationExaption exc){
            System.out.println("Ошибка валидации: " + exc.getValidationErrorInfo());
        }
    }
}
