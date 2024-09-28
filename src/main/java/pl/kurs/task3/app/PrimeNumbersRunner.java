package pl.kurs.task3.app;

import pl.kurs.task3.service.PrimeNumbersService;

import java.util.Arrays;

public class PrimeNumbersRunner {
    public static void main(String[] args) {
        PrimeNumbersService primeNumbers = new PrimeNumbersService();


        System.out.println(Arrays.toString(primeNumbers.superPrimes(2, 150)));
        System.out.println(Arrays.toString(primeNumbers.superPrimes(30, 300)));

    }
}
