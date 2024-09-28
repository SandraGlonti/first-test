package pl.kurs.task3.service;

public class PrimeNumbersService {
    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int sumOfDigits(int number) {
        int summary = 0;
        while (number > 0) {
            summary += number % 10;
            number /= 10;
        }
        return summary;

    }

    public int[] superPrimes(int from, int to) {
        int count = 0;
        for (int i = from; i <= to; i++) {
            if (isPrime(i) && isPrime(sumOfDigits(i))) {
                count++;
            }
        }
        int[] superPrimesArray = new int[count];
        int index = 0;
        for (int i = from; i <= to; i++) {
            if (isPrime(i) && isPrime(sumOfDigits(i))) {
                superPrimesArray[index++] = i;
            }
        }
        return superPrimesArray;

    }
}
