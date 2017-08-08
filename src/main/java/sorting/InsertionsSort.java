package sorting;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by olexandra on 6/27/17.
 */
public class InsertionsSort {
    /**
     * На каждом этапе начало списка упорядочено.
     * Суть в сравнении каждого следующего элемента списка с уже осортированной частью
     * и вставка неотсортированного элемента в подходящее для него место.
     *
     * Arrays.asList(3, 6, 2, 5, 3)

     * Первое действие: сравнить первые элементы 3 и 6 -> они упорядочены, никаких вставок не надо.
     * Второе действие: сравнить упорядоченное начало списка (3, 6) со следующим, третьим  элементом 2.
     *      Начнем сравнение с начала: 2 <= 3 - Да. Значит вставим 2 перед тройкой и удалим с прошлого места.
     *      Получим (2, 3, 6, 5, 3)
     * Третье действие: сравнить упорядоченное начало списка (2, 3, 6) со следующим, четвертым  элементом 5.
     *      Начнем сравнение с начала: 5 <= 2 - Нет.
     *      Сравниваем со вторым элементом: 5 <= 3 - Нет.
     *      Сравниваем со третьим элементом: 5 <= 6 - Да. Значит вставим 5 перед шестеркой и удалим с прошлого места.
     *      Получим (2, 3, 5, 6, 3)
     * Четвертое действие: сравнить упорядоченное начало списка (2, 3, 5, 6) со следующим, пытым  элементом 3.
     *      Начнем сравнение с начала: 3 <= 2 - Нет.
     *      Сравниваем со вторым элементом: 3 <= 3 - Да. Значит вставим 3 перед уже отсортированной тройкой и удалим с прошлого места.
     *      Получим (2, 3, 3, 5, 6)
     *
     * @param list - list to sort
     * @return sorted list
     */

    public static List<Integer> insertionsSort(LinkedList<Integer> list) {
        int iterationNumber = 0;
        for (int i = 1; i < list.size(); i++) {
            System.out.println("Amount of sorted elements:  " + (i - 1));
            System.out.println("Take next number " + list.get(i) + " to place it in the right place.");
            for (int j = 0; j < i; j++) {
                System.out.println("Number of performed checks: " + ++iterationNumber);
                System.out.println("Compare " + list.get(i) + " with " + list.get(j));
                if (list.get(i) <= list.get(j)) {
                    System.out.println("Place " + list.get(i) + " on " + j + " position");
                    list.add(j, list.get(i));
                    list.remove(i + 1);
                    System.out.println("Updated array is " + list);
                    break;
                }
            }
        }
        System.out.println("General number of iterations: " + iterationNumber);
        System.out.println("=========================================================");
        return list;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(3);
        List<Integer> sortedList = insertionsSort(list);
        System.out.println("Sorted array: " + sortedList);
    }
}
