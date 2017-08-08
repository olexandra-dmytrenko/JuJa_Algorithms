package sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oleksandra_Dmytrenko on 8/8/2017.
 */
public class BubbleSortTest {

    /*
    Самый простой тест, который можно придумать это если у нас есть лист уже отсортированный, то он на выходе так и останется.
     */
    @Test
    public void bubbleSortDoesntBreakSortedList() {
        //GIVEN
        List<Integer> listToSort = Arrays.asList(-6, -1, 2, 3, 4);

        //WHEN
        List<Integer> sortedList = BubbleSort.bubbleSort(listToSort);

        //THEN
        assertEquals(listToSort, sortedList);
    }

    /*
    Самый нужный тест, который проверит, что сортировка делает свою работу. Введем список, в котором куча мешанины разного рода:
    первый и последний элементы не на своих местах и в середине все не так, есть дубликаты.
     */
    @Test
    public void bubbleSortActuallySorts() {
        //GIVEN
        List<Integer> listToSort = Arrays.asList(6, -1, 8, -2, 8, 12, -32, 3, 4, 7);
        List<Integer> listToExpect = Arrays.asList(-32, -2, -1, 3, 4, 6, 7, 8, 8, 12);

        //WHEN
        List<Integer> sortedList = BubbleSort.bubbleSort(listToSort);

        //THEN
        assertEquals(listToExpect, sortedList);
    }

    /*
    Еще нужный тест для проверки граничных условий, когда список из одного элемента.
    Говорит о том, что все границы в циклах расставлены правильно.
    */
    @Test
    public void bubbleSortOneElement() {
        //GIVEN
        List<Integer> listToSort = Arrays.asList(Integer.MAX_VALUE);

        //WHEN
        List<Integer> sortedList = BubbleSort.bubbleSort(listToSort);

        //THEN
        assertEquals(listToSort, sortedList);
    }

    /*
    Еще нужный тест для проверки граничных условий, когда список из двух элементов.
    Говорит о том, что все границы в циклах расставлены правильно.
    */
    @Test
    public void bubbleSorTwoElements() {
        //GIVEN
        List<Integer> listToSort = Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE);
        List<Integer> listToExpect = Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE);

        //WHEN
        List<Integer> sortedList = BubbleSort.bubbleSort(listToSort);

        //THEN
        assertEquals(listToExpect, sortedList);
    }
}