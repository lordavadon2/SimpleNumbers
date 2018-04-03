package com.brainacad.simple.SimpleNumber;

import com.brainacad.simple.StringParser.IStringParser;

import java.io.*;

public class Primes implements IPrimes {
        private String simpleNumbers;
        private IStringParser parser;

    public Primes(IStringParser parser) {
        this.simpleNumbers = "";
        this.parser = parser;
    }


    private boolean isSimple(int data){
            if (data <= 1)
                return false;
            else if (data <= 3)
                return true;
            else if (data % 2 == 0 || data % 3 ==0)
                return false;
            int n = 5;
            while (n*n <= data){
                if (data % n ==0 || data % (n + 2) == 0)
                    return false;
                n += 6;
            }
            return true;
        }

        private int getFirstValueOfInt(int data){
            while (data >= 10){
                data /= 10;
            }
            return data;
        }


        @Override
        public void getPrimesFromParser(){
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < parser.getMaxNumber(); i++) {
                if (isSimple(i)){
                    if (getFirstValueOfInt(i) == parser.getPrefixValue()) {
                       builder.append(parser.getPrefix());   //System.out.print("#");
                    }
                      builder.append(i + parser.getDelimeter() + "\n");       //System.out.println(i + ";");
                }
            }
            this.simpleNumbers = builder.toString();
        }

        @Override
        public void writePrimesToFile(String data){
            try{
                FileWriter writer = new FileWriter("NoteSimple.txt", true);
                // запись результата в файл
                writer.write(data);
                writer.append('\n');
                // закрыть поток
                writer.close();
            }
            catch(IOException exp){

                System.out.println("Ошибка записи данных в файл!!!");
            }
        }

    public String getPrimes() {
        return simpleNumbers;
    }
}


