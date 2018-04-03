package com.brainacad.simple;

import com.brainacad.simple.SimpleNumber.Primes;
import com.brainacad.simple.StringParser.*;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Для растчета и вывода резульатов простых чисел введите данные формата:");
        System.out.println("\"Разделитель префикс значение_установки_префикса максимальное_значение_поиска\"");
        System.out.println("Пример:\"; # 3 10000\"");
        String userInput = new Scanner(System.in).nextLine();
        IDataParser parser = new DataParser(userInput, new InputValidator(userInput));
        Primes primes = new Primes(parser);
        try{
            parser.tryParse();
            primes.getSimple();
            System.out.println(primes.getSimpleNumber());
            primes.writeToFile(primes.getSimpleNumber());
        }
        catch (ValidationExaption exc){
            System.out.println("Ошибка валидации: " + exc.getValidationErrorInfo());
        }
    }
}
