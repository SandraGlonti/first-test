package pl.kurs.task2.app;

import pl.kurs.task2.service.SequenceTypeService;

public class SequenceTypeRunner {
    public static void main(String[] args) {
        int[] sequence1 = {5};
        int[] sequence2 = {3, 6, 9, 12, 15};
        int[] sequence3 = {1, 2, 4, 8, 16};
        int[] sequence4 = {4, 7, 20, 33};


        SequenceTypeService getType = new SequenceTypeService();
        System.out.println(getType.getSequenceName(sequence1));
        System.out.println(getType.getSequenceName(sequence2));
        System.out.println(getType.getSequenceName(sequence3));
        System.out.println(getType.getSequenceName(sequence4));
    }
}
