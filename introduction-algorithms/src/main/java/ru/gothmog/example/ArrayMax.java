package ru.gothmog.example;

import java.util.Arrays;

public class ArrayMax {
    public static void main(String[] args) {
        int[] ages = {10, 12, 45, 34, 109, 9, 75, 32, 1, 3, 96, 43, 105};
        int[] top3ValueAges = findTopElement(ages, 13);
        System.out.println(Arrays.toString(top3ValueAges));
    }

    private static int findMaxUnderBoundary(int[] inputArray, int topBoundary) {
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < topBoundary) {
                currentMax = Math.max(currentMax, inputArray[i]);
            }
        }
        return currentMax;
    }

    private static int[] findTopElement(int[] inputArray, int numberOfElements){
        int [] topElements = new int[numberOfElements];

        int previousMax = Integer.MAX_VALUE;

        for (int i = 0; i < numberOfElements; i++) {
            int currentMax = findMaxUnderBoundary(inputArray, previousMax);
            previousMax = currentMax;
            topElements[i] = currentMax;
        }
        return topElements;
    }
}
