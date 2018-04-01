package com.brainacad.simple;

public class Main {
    public static void main(String[] args) {
        Primes primes = new Primes(5000);
        String strSimple = primes.getSimple();
        System.out.println(strSimple);
        primes.writeSimple(strSimple);
        strSimple = primes.getSimple(10000);
        System.out.println(strSimple);
        primes.writeSimple(strSimple);
    }
}
