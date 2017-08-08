package sorting;

import java.util.Arrays;
import java.util.List;

/**
 * Created by olexandra on 6/27/17.
 */
public class BubbleSort {

    /**
     * Каждый раз проходя по массиву переставляем местами каждые 2 соседние элемента, если они не упорядочены.

     * Initial list to sort(3, 6, 2, 1)

     * Первое действие: сравнить 3 и 6 -> переставлять не надо, 3 < 6. Идем сравнивать второй и третий элемент массива.
     * Второе действие: сравнить 6 и 2 -> переставлять надо. Переставим и получим (3, 2, 6, 1). Идем сравнивать третий и четвертый элемент массива.
     * Третье действие: сравнить 6 и 1 -> переставлять надо. Переставим и получим (3, 2, 1, 6). Один цикл закончился. Идем на начало массива и повторяем те же действия.

     * Iteration 1 result (3, 2, 1, 6)
     * Iteration 2 result (2, 1, 3, 6)
     * Iteration 3 result (1, 2, 3, 6);
     * <p>
     * Complexity: O(n - 1) * O(n) = O( (n - 1) * n) = O(n^2 - n) =>
     * (рост квадрата функции намного более ощутим, чем линейный рост, поэтому последним можно принебречь
     * для оценки порядка сложности алгоритма) => O(n^2)
     *
     * @param list - list to sort
     * @return - sorted list
     */
    public static List<Integer> bubbleSort(List<Integer> list) {
        for (int j = 0; j < list.size() - 1; j++) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    swap(list, i, i + 1);
                }
            }
        }
        return list;
    }

    private static void swap(List<Integer> list, int i, int i1) {
        Integer temp = list.get(i);
        list.set(i, list.get(i + 1));
        list.set(i + 1, temp);
    }

    public static void main(String[] args) {
        List<Integer> integers = BubbleSort.bubbleSort(Arrays.asList(3, 6, 2, 1));
        System.out.println(integers);
    }
}
