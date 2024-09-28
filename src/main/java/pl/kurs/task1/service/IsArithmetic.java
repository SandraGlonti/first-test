package pl.kurs.task1.service;

public class IsArithmetic {
    public boolean isArithmetic(int[] sequence) {
        if (sequence.length < 2) {
            return false;
        }
        int difference = sequence[1] - sequence[0];
        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != difference) {
                return false;
            }
        }
        return true;
    }

}
