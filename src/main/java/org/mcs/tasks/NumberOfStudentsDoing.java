package org.mcs.tasks;

/**
 * Даны два целочисленных массива startTime и endTime и дано целое число queryTime.
 *
 * Первый студент начал выполнять домашнее задание в момент времени startTime[i]
 * и закончил его в момент времени endTime[i].
 *
 * Возвращает количество учеников, выполняющих домашнее задание в момент времени queryTime.
 * Более формально, возвращается количество студентов, для которых время запросаTime лежит в интервале
 * [startTime[i], endTime[i]] включительно.
 *
 * Вход: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
 * Выход: 1
 * Объяснение: У нас есть 3 студента:
 * Первый студент начал делать домашнее задание в момент времени 1, закончил в момент времени 3 и ничего не делал в момент времени 4.
 * Второй студент начал делать домашнее задание в момент времени 2 и закончил в момент времени 2, а также ничего не делал в момент времени 4.
 * Третий студент начал выполнять домашнее задание в момент времени 3 и закончил в момент времени 7, и был единственным студентом, выполнявшим домашнее задание в момент времени 4.
 *
 * Вход: startTime = [4], endTime = [4], queryTime = 4
 * Выход: 1
 * Объяснение: Единственный студент делал домашнее задание в queryTime.
 */
public class NumberOfStudentsDoing {

    public static void main(String[] args) {
        int[] startTime = new int[] {1,2,3};
        int[] endTime = new int[] {3,2,7};
        int queryTime = 4;
        System.out.println(busyStudent(startTime, endTime, queryTime));
    }

    private static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for (int i = 0; i < startTime.length; i++) {
            int start = startTime[i];
            int end = endTime[i];
            if (start <= queryTime && queryTime <= end) {
                result++;
            }
        }
        return result;
    }
}
