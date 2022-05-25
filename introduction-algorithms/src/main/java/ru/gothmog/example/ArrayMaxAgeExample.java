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

        int maxAgeIsSortForUp = calculateMaxAgeForSortUp(ages);
        System.out.println(MAX_AGE + maxAgeIsSortFor + " " + maxAgeIsSortForUp);
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

    private static int calculateMaxAgeForSortUp(int[] arrays) {
        int maxAge1 = 0;
        int maxAge2 = 0;
        if (arrays.length != 0) {
            for (int i = 0; i < arrays.length; i++) {
                maxAge1 = max(maxAge1, arrays[i]);
            }
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i] < maxAge1) {
                    maxAge2 = max(maxAge2, arrays[i]);
                }
            }
        }
        return maxAge2;
    }

    private static int max(int a, int b) {
        return (a >= b) ? a : b;
    }
}
