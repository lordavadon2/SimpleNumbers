package com.brainacad.simple;

public class Main {
    public static void main(String[] args) {
        Primes primes = new Primes(5000);
        primes.printSimple();
        System.out.println();
        primes.printSimple(10000);

    }
}
