package ru.gothmog;

import java.util.Scanner;

/**
 * Вопрос №1 из 1
 * 54:34
 * <p>
 * Один человек хотел накопить денег на видеокарту и у него родился следующий план накоплений:
 * Каждый день недели он будет откладывать на 1 шекель больше чем в предыдущий,
 * а каждый понедельник на 1 шекель больше чем в предыдущий понедельник Начать он решил с 1 шекеля в понедельник.
 * Нужно написать программу, которая будет определять, сколько шекелей будет у человека через N дней.
 * <p>
 * Входные данные:
 * <p>
 * Одно число N обозначающее количество дней, где 1 <= N <= 1000
 * <p>
 * Примеры:
 * <p>
 * 6 дней: 1 + 2 + 3 + 4 + 5 + 6 = 21
 * 7 дней:  1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
 * 10 дней: (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37
 * 14 дней: (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) = 63
 * 15 дней: (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + 3 = 66
 * 21 дней  (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8 + 9) = 105
 * 24 дней  (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8 + 9) + (4 + 5 + 6) = 120
 * 25 дней  (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8 + 9) + (4 + 5 + 6 + 7) = 127
 */
public class TinkoffTestAlgorithmExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calculateDeposit(scanner.nextInt()));
    }

    /**
     * Решение с помощью многомерного массива.
     *
     * @param days количество дней.
     * @return сколько шекелей будет у человека через N дней.
     */
    private static int calculateDeposit(int days) {
        int daysOfTheWeek = 7;
        int depositResult = 0;
        if (days >= 1 && days <= 1000) {
            int numberOfWeeks = days / daysOfTheWeek;
            int[][] calendarBoard = getCalendarBoard(daysOfTheWeek, numberOfWeeks, days);
            for (int i = 0; i < calendarBoard.length; i++) {
                for (int j = 0; j < calendarBoard[i].length; j++) {
                    depositResult = depositResult + calendarBoard[i][j];
                }
            }
        }
        return depositResult;
    }

    /**
     * Многомерный массив в виде доски календаря.
     *
     * @param length количество столбцов - равен 1 неделе - 7 дней.
     * @param height количество строк - равен количеству недель полученных в результате
     *               деления всех дней days на количество дней в неделе.
     * @param days   количество дней, задается пользователем.
     * @return Многомерный массив.
     */
    private static int[][] getCalendarBoard(int length, int height, int days) {
        int count = 1;
        int level = 0;
        int restDaysWeek = days - (length * height);
        int heightResult = restDaysWeek > 0 ? height + 1 : height;
        int restDaysWeekResult = restDaysWeek > 0 ? restDaysWeek : length;
        int[][] calendarBoard = new int[heightResult][length];
        for (int i = 0; i < calendarBoard.length; i++) {
            for (int j = 0; j < calendarBoard[i].length; j++) {
                if (heightResult > 1 && count <= length) {
                    calendarBoard[i][j] = count;
                    count++;
                }
                if (heightResult == 1 && count <= restDaysWeekResult) {
                    calendarBoard[i][j] = count;
                    count++;
                }
                if (i == level && level > 0 && restDaysWeekResult == 0) {
                    calendarBoard[i][j] = calendarBoard[i - 1][j] + 1;
                }
                if (i == level && level > 0 && restDaysWeekResult > 0) {
                    calendarBoard[i][j] = calendarBoard[i - 1][j] + 1;
                }
                if (i == level && level == heightResult - 1 && level > 0 && restDaysWeekResult > 0) {
                    calendarBoard[i][j] = calendarBoard[i - 1][j] + 1;
                    if (j + 1 == restDaysWeekResult) {
                        break;
                    }
                }
            }
            level++;
        }
        return calendarBoard;
    }
}
