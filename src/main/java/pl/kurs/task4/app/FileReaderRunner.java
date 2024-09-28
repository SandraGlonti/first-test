package pl.kurs.task4.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileReaderRunner {
    public static void main(String[] args) throws FileNotFoundException {
        String[] lines = getFileContent();
        for (String line : lines) {
            if (line != null) {
                String[] linesSeparated = line.split(" ");
                processLine(linesSeparated);
            }
        }
    }

    public static String[] getFileContent() throws FileNotFoundException {
        String fileName = "liczby.txt";
        File file = new File(fileName);
        if (file.exists()) {
            String content = "";
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                if (line != null && !line.isBlank()) {
                    content += line + "\n";
                }
            }
            scanner.close();
            return content.isEmpty() ? new String[0] : content.trim().split("\n");


        } else {
            System.out.println("Plik nie istnieje");
            return null;
        }
    }

    public static void processLine(String[] linesSeparated) {
        int[] numbers = new int[linesSeparated.length];
        for (int i = 0; i < linesSeparated.length; i++) {
            numbers[i] = Integer.parseInt(linesSeparated[i]);

        }
        System.out.println("Raportowana linia: " + Arrays.toString(linesSeparated));
        String monotonicity = determineMonotonicity(numbers);
        System.out.println("Monotoniczność: " + monotonicity);
        int min = determineMin(numbers);
        int max = determineMax(numbers);
        System.out.println("Min: " + min + ", Max: " + max);

        int mostFrequent = findMostFrequent(numbers);
        System.out.println("Najpopularniejsza liczba w ciągu: " + mostFrequent);

        boolean allNumbersPresent = checkAllNumbersPresent(numbers, min, max);
        System.out.println("Wszystkie liczby naturalne między min a max: " + allNumbersPresent);
        System.out.println();

    }

    private static String determineMonotonicity(int[] numbers) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) {
                decreasing = false;
            } else if (numbers[i] < numbers[i - 1]) {
                increasing = false;
            }
        }
        if (increasing) {
            return "rosnący";
        } else if (decreasing) {
            return "malejący";
        } else {
            return "nie monotoniczny";
        }
    }

    private static int determineMin(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    private static int determineMax(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    private static int findMostFrequent(int[] numbers) {
        int mostFrequentNumber = numbers[0];
        int frequency = 1;

        for (int number : numbers) {
            int counter = 0;
            for (int i : numbers) {
                if (number == i) {
                    counter++;
                }
            }
            if (counter > frequency) {
                frequency = counter;
                mostFrequentNumber = number;

            }

        }
        return mostFrequentNumber;

    }

    private static boolean checkAllNumbersPresent(int[] numbers, int min, int max) {
        boolean isAllPresent = true;
        for (int i = min; i <= max; i++) {
            boolean present = false;
            for (int number : numbers) {
                if (number == i) {
                    present = true;
                    break;
                }
            }
            if (!present) {
                isAllPresent = false;
                break;
            }
        }
        return isAllPresent;
    }

}
