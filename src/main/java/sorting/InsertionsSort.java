package sorting;

import java.util.LinkedList;

/**
 * Created by olexandra on 6/27/17.
 */
public class InsertionsSort {
    /**
     * Arrays.asList(3, 6, 2, 5)
     * (3, 6, 2, 5)
     * (2, 3, 6, 5, 3)
     * (2, 3, 5, 3, 6)
     * (2, 3, 3, 5, 6)
     *
     * @param list
     * @return
     */

    public static LinkedList<Integer> insertionsSort(LinkedList<Integer> list) {
        int iterationNumber = 0;
        for (int i = 1; i < list.size(); i++) {
            System.out.println("Take next number " + list.get(i) + " to place it in the right place.");
            for (int j = 0; j < i; j++) {
                System.out.println(++iterationNumber + " Amount of sorted elements:  " + (i - 1));
                if (list.get(i) < list.get(j)) {
                    list.add(j, list.get(i));
                    list.remove(i + 1);
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(5);
        LinkedList sortedList = insertionsSort(list);
        System.out.println("Sorted array: " + sortedList);
    }
}
