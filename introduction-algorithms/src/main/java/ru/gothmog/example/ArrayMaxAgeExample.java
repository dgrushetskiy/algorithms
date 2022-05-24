package ru.gothmog.example;

import java.util.Arrays;

public class ArrayMaxAgeExample {
    private static final String MAX_AGE = "max age = ";

    public static void main(String[] args) {
        int[] ages = {10, 12, 45, 34, 105, 9, 75, 32, 1, 3, 96, 43, 105};
        int maxAgeIsSort = calculateMaxAgeSort(ages);
        System.out.println(MAX_AGE + maxAgeIsSort);

        int maxAgeIsSortFor = calculateMaxAgeForSort(ages);
        System.out.println(MAX_AGE + maxAgeIsSortFor);
        int ageMom = 45;
        int ageDad = 52;

        int maxAgeMomAndDad = max(ageDad, ageMom);
        System.out.println(MAX_AGE + maxAgeMomAndDad);

        int ageGrandma = 85;

        int maxAgeFamily = max(maxAgeMomAndDad, ageGrandma);
        System.out.println(MAX_AGE + maxAgeFamily);

    }

    private static int calculateMaxAgeSort(int[] arrays) {
        int maxAge = 0;
        if (arrays.length != 0) {
            Arrays.sort(arrays);
            maxAge = arrays[arrays.length - 1];
        }
        return maxAge;
    }

    private static int calculateMaxAgeForSort(int[] arrays) {
        int maxAge = 0;
        if (arrays.length != 0) {
            for (int i = 0; i < arrays.length; i++) {
                maxAge = max(maxAge, arrays[i]);
            }
        }
        return maxAge;
    }

    private static int max(int a, int b) {
        return (a >= b) ? a : b;
    }
}
