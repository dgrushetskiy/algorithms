package ru.gothmog.example;

public class ArrayMax {
    public static void main(String[] args) {

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

        return topElements;
    }
}
