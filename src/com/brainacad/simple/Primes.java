package com.brainacad.simple;

import java.io.*;

public class Primes {
        private int maxNumber = 0;

    public Primes(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    private boolean ifSimple(int data){
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

        public String getSimple (){
            return getSimple(maxNumber);
        }


        public String getSimple (int maxNumber){
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < maxNumber; i++) {
                if (ifSimple(i)){
                    if (getFirstValueOfInt(i) == 3) {
                       builder.append('#');   //System.out.print("#");
                    }
                      builder.append(i + ";" + "\n");       //System.out.println(i + ";");
                }
            }
            return  builder.toString();
        }

        public void writeSimpleToFile(String data){
            try{
                FileWriter writer = new FileWriter("NoteSimple.txt", true);
                // запись результата в файл
                writer.write(data);
                writer.append('\n');
                // закрыть поток
                writer.flush();
            }
            catch(IOException exp){

                System.out.println(exp.getMessage());
            }
        }
}


