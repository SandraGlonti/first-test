package pl.kurs.task1.app;

import pl.kurs.task1.service.IsArithmetic;

public class IsArithmeticRunner {
    public static void main(String[] args) {
        int[] sequence1 = {5};
        int[] sequence2 = {2, 4, 6, 8, 10, 12};
        int[] sequence3 = {3, 6, 12, 18};

        IsArithmetic isArithmetic = new IsArithmetic();

        System.out.println(isArithmetic.isArithmetic(sequence1));
        System.out.println(isArithmetic.isArithmetic(sequence2));
        System.out.println(isArithmetic.isArithmetic(sequence3));


    }
}
