package pl.kurs.task2.service;

public class SequenceTypeService {
    public String getSequenceName(int[] sequence) {
        if (sequence.length < 2) {
            return "INNY";
        }
        boolean isArithmetic = true;
        boolean isGeometric = true;
        int arithmeticDifference = sequence[1] - sequence[0];
        double geometricRatio = (double) sequence[1] / sequence[0];

        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != arithmeticDifference) {
                isArithmetic = false;
            }
            if ((double) sequence[i] / sequence[i - 1] != geometricRatio) {
                isGeometric = false;
            }
        }
        if (isArithmetic) {
            return "ARYTMETYCZNY";
        } else if (isGeometric) {
            return "GEOMETRYCZNY";

        } else {
            return "INNY";
        }
    }

}
